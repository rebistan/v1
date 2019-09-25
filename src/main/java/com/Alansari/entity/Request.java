package com.Alansari.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "request", catalog = "ATC")
@ApiModel(description = "All details about the Request. ")
public class Request {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @ApiModelProperty(notes = "The Request Number")
	    @Column(name = "req_id",nullable = false)
	    private Integer reqid;
	    
	    @ApiModelProperty(notes = "The Request Sender")
	    @Column(name = "send_id",nullable = false)
	    private Integer sender;
	    
	    @ApiModelProperty(notes = "The Request Receiver")
	    @Column(name = "rece_id",nullable = false)
	    private Integer receiver;
	    
	    @ApiModelProperty(notes = "The Request ")
	    @Column(name = "msg",nullable = false)
	    private String msg;
	    
	    @ApiModelProperty(notes = "The Request Attachment ")
	    @Column(name = "attach")
	    private byte[] attach;
	    
	    @Column(columnDefinition="bit default 0")
	    private Boolean respose;
	    
		public Integer getReqid() {
			return reqid;
		}

		public Boolean getRespose() {
			return respose;
		}

		public void setRespose(Boolean respose) {
			this.respose = respose;
		}

		public Integer getSender() {
			return sender;
		}

		public Integer getReceiver() {
			return receiver;
		}

		public String getMsg() {
			return msg;
		}

		public byte[] getAttach() {
			return attach;
		}

	
		public void setReqid(Integer reqid) {
			this.reqid = reqid;
		}

		public void setSender(Integer sender) {
			this.sender = sender;
		}

		public void setReceiver(Integer receiver) {
			this.receiver = receiver;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void setAttach(byte[] attach) {
			this.attach = attach;
		}
			
}