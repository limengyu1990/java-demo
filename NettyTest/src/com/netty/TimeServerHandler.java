package com.netty;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
/**
 * 用POJO代替ChannelBuffer
 */
class TimeServerHandler extends SimpleChannelHandler {

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) 
                throws Exception {
        Persons person = new Persons("周杰伦123", 31, 10000.44);
        ChannelFuture future = e.getChannel().write(person);
        future.addListener(ChannelFutureListener.CLOSE);
    }
}
