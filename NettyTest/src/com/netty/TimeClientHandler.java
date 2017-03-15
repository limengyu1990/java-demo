package com.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class TimeClientHandler extends SimpleChannelHandler{    
    
    @Override    
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)    
            throws Exception {    
        Persons person = (Persons)e.getMessage();    
        System.out.println("person:"+person);    
        e.getChannel().close();    
    }    
}  
