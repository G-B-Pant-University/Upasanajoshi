import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] female= new String[21];//stores name of females
        String[] male= new String[21];//stores name of males
        int f=0;//count no. of female
        int m=0;//count no. of female
        for(int i=0; i<5;i++){
            System.out.println("Enter Name");
            String name=sc.nextLine();
            System.out.println("Enter Gender");
            char gen=sc.next().charAt(0);
            if (gen=='F'||gen=='f'){
                female[f]=name;
                f++;
            }
            else {
                male[m]=name;
                m++;
            }
            System.out.println("Enter Course");
            String course=sc.nextLine();

        }
        sc.close();
        room_alloc(female, male, f,m);

    }
    public static void room_alloc(String[] female, String[] male, int f, int m){
        int f_rooms=f/2;//total no. of rooms for female
        int m_rooms=m/2;//total no. of rooms for male
        int k=0;
        int u=0;
        String[][] femaleroom= new String[f_rooms][2];
        String[][] maleroom= new String[m_rooms][2];

        //Room allotment
        for(int i=0;i<f_rooms;i++){
            for (int j=0;j<2;j++){
                femaleroom[i][j]=female[k];
                k++;
            }
        }
        for(int i=0;i<m_rooms;i++){
            for (int j=0;j<2;j++){
                maleroom[i][j]=male[u];
                u++;
            }
        }

        //Print room allotments info
        System.out.println("Rooms alloted to female");
        for(int i=0;i<f_rooms;i++){
            System.out.println("Room no: "+i);
            for (int j=0;j<2;j++){
                System.out.print(femaleroom[i][j]+" ");
            }
            System.out.println(" ");
        }        
        System.out.println("Rooms alloted to male");
        for(int i=0;i<m_rooms;i++){
            System.out.println("Room no: "+i);
            for (int j=0;j<2;j++){
                System.out.print(maleroom[i][j]+" ");
            }
            System.out.println(" " );
        }        

        //Prints name of student left 
        if(f%2!=0){
            System.out.println("No room alloted to: "+ female[k]);
        }else{
            System.out.println("No room alloted to: "+ male[u]);

        }
    }
}
