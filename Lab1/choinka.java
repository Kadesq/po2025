public class choinka{
    public static void main (String[] args) {
        System.out.println("Hello, World!");
        
        if(args.length !=1){
            System.out.println("Podaj wysokosc: ");
            return;
        }

        int wysokosc = Integer.parseInt(args[0]);

        for(int i=0;i<=wysokosc;i++){
            for(int j=0; j<(i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}   