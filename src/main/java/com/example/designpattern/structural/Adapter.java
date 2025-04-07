package com.example.designpattern.structural;

import lombok.Data;

/**
 * help two unrelated interfaces to work together, joining these unrelated interfaces
 * work as a subclass to have another class (or interface)
 */
public class Adapter {
    public static void main(String[] args) {
        System.out.println(getVolt(new SocketClassAdapter(), 3));
        System.out.println(getVolt(new SocketObjectAdapter(), 120));
    }

    private static Volt getVolt(SocketAdapter socketAdapter, int voltNumber) {
        switch(voltNumber) {
            case 3: return socketAdapter.get3Volt();
            case 12: return socketAdapter.get12Volt();
            case 120: return socketAdapter.get120Volt();
        }
        return null;
    }
}


interface SocketAdapter {
    Volt get120Volt();
    Volt get12Volt();
    Volt get3Volt();
}

/**
 * Adapter based on inheritance
 */
class SocketClassAdapter extends WallSocket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        int volts = getVolt().getVolts();
        return new Volt(volts / 2);
    }

    @Override
    public Volt get12Volt() {
        int volts = getVolt().getVolts();
        return new Volt(volts / 20);
    }

    @Override
    public Volt get3Volt() {
        int volts = getVolt().getVolts();
        return new Volt(volts / 80);
    }
}

/**
 * Adapter based on composition
 */
class SocketObjectAdapter implements SocketAdapter {

    WallSocket wallSocket = new WallSocket();

    @Override
    public Volt get120Volt() {
        int volts = wallSocket.getVolt().getVolts();
        return new Volt(volts / 2);
    }

    @Override
    public Volt get12Volt() {
        int volts = wallSocket.getVolt().getVolts();
        return new Volt(volts / 20);
    }

    @Override
    public Volt get3Volt() {
        int volts = wallSocket.getVolt().getVolts();
        return new Volt(volts / 80);
    }
}



class WallSocket {
    public Volt getVolt() {
        return new Volt(240);
    }
}

@Data
class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }
}

