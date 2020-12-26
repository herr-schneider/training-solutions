package isahasa.htmlmarchaller;

public class Client {
    Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public int writeToChannel(TextSource textSource){
        byte[] byteArrray = textSource.getPlainText().getBytes();
        return channel.writeByte(byteArrray);
    }

}
