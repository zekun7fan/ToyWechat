package org.example.request_service.service;


import org.example.commonUtils.dto.Message;
import org.example.commonUtils.entity.Request;
import org.example.commonUtils.entity.RequestExample;
import org.example.commonUtils.exception.CustomException;
import org.example.request_service.dao.RequestMapper;
import org.example.request_service.enumType.ReqStatus;
import org.example.request_service.exception.CustomizeErrorCode;
import org.example.request_service.rpc.FriendController;
import org.example.request_service.rpc.MessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {


    @Autowired
    private RequestMapper mapper;

    @Autowired
    private FriendController friendController;


    @Autowired
    private MessageController messageController;


    public boolean addRequest(Request request) {
        RequestExample example = new RequestExample();
        example.createCriteria()
                .andRequestUserIdEqualTo(request.getRequestUserId())
                .andHandleUserIdEqualTo(request.getHandleUserId())
                .andStatusEqualTo(ReqStatus.PENDING.getVal());
        List<Request> list = mapper.selectByExample(example);
        if (!list.isEmpty()) {
            throw new CustomException(CustomizeErrorCode.REQ_DUPLICATION_EXCEPTION);
        }
        int insert = mapper.insert(request);
        if (insert != 1) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_ERROR_EXCEPTION);
        }
        return true;
    }


    public boolean updateRequest(Request request) {
        int i = mapper.updateByPrimaryKeySelective(request);
        if (i != 1) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_ERROR_EXCEPTION);
        }
        if (request.getStatus().equals(ReqStatus.APPROVED.getVal())) {
            Boolean r = friendController.addFriend(request.getRequestUserId(), request.getHandleUserId()).getData();
            if (!r) {
                throw new CustomException(CustomizeErrorCode.SYSTEM_ERROR_EXCEPTION);
            }
        }
        sendNotification(request);
        return true;
    }


    public List<Request> getSentAndPendingRequests(String uid) {
        RequestExample example = new RequestExample();
        example.createCriteria()
                .andRequestUserIdEqualTo(uid)
                .andStatusEqualTo(ReqStatus.PENDING.getVal());
        return mapper.selectByExample(example);
    }


    public List<Request> getSentAndFinishedRequests(String uid) {
        RequestExample example = new RequestExample();
        example.createCriteria()
                .andRequestUserIdEqualTo(uid)
                .andStatusNotEqualTo(ReqStatus.PENDING.getVal());
        return mapper.selectByExample(example);

    }


    public List<Request> getHandledAndPendingRequests(String uid) {
        RequestExample example = new RequestExample();
        example.createCriteria()
                .andHandleUserIdEqualTo(uid)
                .andStatusEqualTo(ReqStatus.PENDING.getVal());
        return mapper.selectByExample(example);

    }


    public List<Request> getHandledAndFinishedRequests(String uid) {
        RequestExample example = new RequestExample();
        example.createCriteria()
                .andHandleUserIdEqualTo(uid)
                .andStatusNotEqualTo(ReqStatus.PENDING.getVal());
        return mapper.selectByExample(example);
    }


    private String createNotification(Request request) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ADD Friend INFO]");
        if (request.getStatus().equals(ReqStatus.APPROVED.getVal())) {
            sb.append(" approved your request");
        } else if (request.getStatus().equals(ReqStatus.REJECTED.getVal())) {
            sb.append(" rejected your request");
        }
        return sb.toString();
    }

    private void sendNotification(Request request) {
        String str = createNotification(request);
        Message message = new Message(request.getHandleUserId(), request.getRequestUserId(), str, null, null);
        messageController.sendMessage(message);

    }

}
