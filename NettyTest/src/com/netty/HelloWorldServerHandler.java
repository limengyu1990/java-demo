package com.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class HelloWorldServerHandler extends SimpleChannelHandler {
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) 
            throws Exception {
        e.getChannel().write("Hello, World");
        e.getChannel().write("Hello, hadoop");
    }

    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        System.out.println("Unexpected exception from downstream." + e.getCause());
        e.getChannel().close();
    }
}
