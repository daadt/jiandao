package com.example.jdd.net;

public class NetWorkFactory {

//    制造产品
//    RetrfitUtils .HttpUrlConnettionUtils

    private static int NET_TYPE = 1;

   public INetWork network;


   private static NetWorkFactory netWorkFactory;

    public static NetWorkFactory getInstance() {
        if(netWorkFactory == null){
            synchronized (RetrofitUtils.class){
                if (netWorkFactory == null){
                    netWorkFactory = new NetWorkFactory();
                }
            }
        }
        return netWorkFactory;
    }

    public INetWork getNetWork(){
        if(NET_TYPE == 1){
            network = RetrofitUtils.getInstance();
        }else {
            network = HttpUrlConnetionUtils.getInstance();
        }
        return  network;
    }

}