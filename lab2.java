import java.util.Scanner;

public class Student {  
    int id;
    String name;
    String course;
    char gen;
    Student(int id, String name, String course, char gen){
        this.id=id;
        this.name=name;
        this.course=course;
        this.gen=gen;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int id;
        String name,course;
        char gen;
        Student[] studentArray=new Student[21];
        System.out.println("Enter Students detail");
        for(int i=0;i<21;i++){
            System.out.println("Id: ");
            id=sc.nextInt();
            sc.nextLine();
            System.out.println("Name: ");
            name=sc.nextLine();
            System.out.println("Course: ");
            course=sc.nextLine();
            System.out.println("Gender: ");
            gen=sc.next().charAt(0);
            studentArray[i]=new Student(id, name, course, gen);
        }
        sc.close();
        room_alloc(studentArray);
    }

    public static void room_alloc(Student[] studentArray){
        int total_female=0;
        int total_male=0;
        for (Student s : studentArray) {
            if (s.gen=='f'|| s.gen=='F'){
                
                total_female++;
            }
        }
        total_male=21-total_female;
        int f_rooms=total_female/2;//total no. of rooms for female
        int m_rooms=total_male/2;//total no. of rooms for male
        int u=0,v=0,j=0,k=0;//for 2D array traversing
        Student[][] femaleroom= new Student[f_rooms][2];
        Student[][] maleroom= new Student[m_rooms][2];
        
        //Room allotment
        for (int i=0;i<studentArray.length;i++) {
            if(studentArray[i].gen=='f'|| studentArray[i].gen=='F'){
                if(j<f_rooms){
                    femaleroom[j][k]=studentArray[i];
                    k=(k+1)%2;
                    if(k==0){
                        j++;
                    }
                }else{
                    System.out.println("Female student left:"+studentArray[i].name);
                }
            }else{
                if(u<m_rooms){
                    maleroom[u][v]=studentArray[i];
                    v=(v+1)%2;
                    if(v==0){
                        u++;
                    }
                }else{
                    System.out.println("Male student left:"+studentArray[i].name);
                }

            }
        }

//Display alloted student 
System.out.println("\nRoom alloted to Female");
int i=1;
for (Student[] row : femaleroom) {
    System.out.print("Room no. "+ i);
    for (Student student : row) {
        if (student != null) {
            System.out.print(" "+ student.name + " ");
        }
    }
    i++;
    System.out.println();
}

System.out.println("\nRoom alloted to Male");
i=1;
for (Student[] row : maleroom) {
    System.out.print("Room no. "+ i);
    for (Student student : row) {
        if (student != null) {
            System.out.print(" "+student.name + " ");
        }
    }
    i++;
    System.out.println();
}
        
    }
}

