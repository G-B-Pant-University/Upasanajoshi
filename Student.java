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
        Student[] studentArray=new Student[21];
        studentArray[0]=new Student(64220, "Upasana", "MCA", 'f');
        studentArray[1]=new Student(64274, "Anushia", "MCA", 'f');
        studentArray[2]=new Student(64247, "Kasish", "MCA", 'f');
        studentArray[3]=new Student(64248, "Amit", "MCA", 'm');
        studentArray[4]=new Student(64231, "Raghav", "MCA", 'm');
        studentArray[5]=new Student(64228, "Siya", "MCA", 'f');
        studentArray[6]=new Student(64243, "Divya", "MCA", 'f');
        studentArray[7]=new Student(64217, "Kavya", "MCA", 'f');
        studentArray[8]=new Student(64147, "Chhavi", "MCA", 'f');
        studentArray[9]=new Student(64207, "Akansha", "MCA", 'f');
        studentArray[10]=new Student(64257, "Isha", "MCA", 'f');
        studentArray[11]=new Student(64937, "Nandita", "MCA", 'f');
        studentArray[12]=new Student(64447, "Yash", "MCA", 'm');
        studentArray[13]=new Student(64711, "Bhavesh", "MCA", 'm');
        studentArray[14]=new Student(64107, "Yogesh", "MCA", 'm');
        studentArray[15]=new Student(64295, "Naman", "MBA", 'm');
        studentArray[16]=new Student(64243, "Harsh", "MCA", 'm');
        studentArray[17]=new Student(64277, "Krishna", "MBA", 'm');
        studentArray[18]=new Student(64242, "Kartik", "MCA", 'm');
        studentArray[19]=new Student(64211, "Shivam", "MBA", 'm');
        studentArray[20]=new Student(64227, "Ravi", "MBA", 'm');
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

