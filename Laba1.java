public class Laba1 {
    static class Mouse {
        public Brand brand;
        String id;
        Specifications specifications;
    }

    static class Specifications{
        double weight;
        boolean processor, silentButtons;
        ConnectionType connectionType;
        Demensions demensions;
        int numberOfButtons;
    }

    static class Demensions{
        double height, width;
    }

    enum Brand{
        A4Tech, DEXP, Defender, Oklick, Smartbuy, Logitech
    }
    enum ConnectionType{
        Wireless, Wired, Combined
    }
}
