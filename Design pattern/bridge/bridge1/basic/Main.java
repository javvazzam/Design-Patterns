package bridge.bridge1.basic;

class Tv {
    private int volume;
    private int channel;

    public Tv(int volume, int channel) {
        this.volume = volume;
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}

class RemoteControl {
    private Tv device;

    public RemoteControl(Tv device) {
        this.device = device;
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    public static void main(String[] args) {
        Tv myTv = new Tv(50, 5);
        RemoteControl myRemote = new RemoteControl(myTv);

        System.out.println("Volume inicial: " + myTv.getVolume()); 
        System.out.println("Canal inicial: " + myTv.getChannel()); 

        myRemote.volumeDown();
        System.out.println("Volume después de bajar: " + myTv.getVolume()); 

        myRemote.volumeUp();
        System.out.println("Volume después de subir: " + myTv.getVolume()); 

        myRemote.channelDown();
        System.out.println("Canal después de bajar: " + myTv.getChannel()); 

        myRemote.channelUp();
        System.out.println("Canal después de subir: " + myTv.getChannel());
    }
}