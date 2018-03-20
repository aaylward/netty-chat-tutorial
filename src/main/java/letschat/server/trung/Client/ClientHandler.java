package letschat.server.trung.Client;

import letschat.server.trung.Server.RequestData;
import letschat.server.trung.Server.ResponseData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    private String mess;

    public ClientHandler() {}

    public ClientHandler(String mess) {
        this.mess = mess;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {

        RequestData msg = new RequestData();
        msg.setIntValue(123);

        Scanner scan= new Scanner(System.in);
        msg.setStringValue(scan.nextLine());



        ChannelFuture future = ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println((ResponseData) msg);
        ctx.close();
    }
}
