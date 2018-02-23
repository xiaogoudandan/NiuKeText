public class javatoc {
    public static void main(String[] args) {
        String str="FF000100FF";
        Integer integer=0xff;
        Integer integer1=0x00;
        Integer integer2=0x00;
        Byte[] bytes=new Byte[4];
        bytes[1]=integer1.byteValue();
        bytes[2]=integer2.byteValue();
    }
}
