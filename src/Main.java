import model.*;

public class Main {

    public static void main(String[] args) {
        DiskDrive myDiskDrive = new DiskDrive(DiskType.HARD, 512);
        Motherboard myMotherboard = new Motherboard("ASUS");
        RandomAccessMemory myRAM = new RandomAccessMemory("Kingstone", 4);
        VideoCard myVideoCard = new VideoCard("NVIDIA", "GeForce", 1);

        Computer myComp = new Computer(myMotherboard,
                myRAM,myVideoCard, myDiskDrive);

        /*
         * it is excessive to use toString method
         * as System.out.println(myComp.toString)
         * is equal to System.out.printLn(myComp)
         */
        System.out.println(myComp);
    }

}
