package bridge.bridge1.chatgpt.run1;

// Strategy Interface
interface Device {
    int getVolume();

    void setVolume(int volume);

    void channelDown();

    void channelUp();
}

// Concrete Strategy: Tv
class Tv implements Device {
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

    @Override
    public void channelDown() {
        setChannel(getChannel() - 1);
    }

    @Override
    public void channelUp() {
        setChannel(getChannel() + 1);
    }
}

// Concrete Strategy: Radio
class Radio implements Device {
    private int volume;
    private double frequency;

    public Radio(int volume, double frequency) {
        this.volume = volume;
        this.frequency = frequency;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public void channelDown() {
        setFrequency(getFrequency() - 0.1);
    }

    @Override
    public void channelUp() {
        setFrequency(getFrequency() + 0.1);
    }
}

// Context: RemoteControl
class RemoteControl {
    private Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    public void channelDown() {
        device.channelDown();
    }

    public void channelUp() {
        device.channelUp();
    }

    public static void main(String[] args) {
        Tv myTv = new Tv(50, 5);
        Radio myRadio = new Radio(30, 101.1);

        RemoteControl tvRemote = new RemoteControl(myTv);
        RemoteControl radioRemote = new RemoteControl(myRadio);

        System.out.println("TV Volume inicial: " + myTv.getVolume());
        System.out.println("TV Canal inicial: " + myTv.getChannel());

        tvRemote.volumeDown();
        System.out.println("TV Volume después de bajar: " + myTv.getVolume());

        tvRemote.volumeUp();
        System.out.println("TV Volume después de subir: " + myTv.getVolume());

        tvRemote.channelDown();
        System.out.println("TV Canal después de bajar: " + myTv.getChannel());

        tvRemote.channelUp();
        System.out.println("TV Canal después de subir: " + myTv.getChannel());

        System.out.println("Radio Volume inicial: " + myRadio.getVolume());
        System.out.println("Radio Frecuencia inicial: " + myRadio.getFrequency());

        radioRemote.volumeDown();
        System.out.println("Radio Volume después de bajar: " + myRadio.getVolume());

        radioRemote.volumeUp();
        System.out.println("Radio Volume después de subir: " + myRadio.getVolume());

        radioRemote.channelDown();
        System.out.println("Radio Frecuencia después de bajar: " + myRadio.getFrequency());

        radioRemote.channelUp();
        System.out.println("Radio Frecuencia después de subir: " + myRadio.getFrequency());
    }
}
