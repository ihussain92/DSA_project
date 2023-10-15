import java.lang.String;
import java.util.Scanner;;


class phonebook{

    Node data;
    static int size = 0;

    private static class Node{
        int Number;
        String Name;
        Node next;
        
        Node(int num , String name){
            this.Name = name;
            this.Number = num;
            next = null; 
        }

    }

    public void addNumber(int Num, String name){
        Node data = new Node(Num, name);
        data.next = this.data;
        this.data = data;
        
        ++size;

    }

    public int size(){
        return size;
    }

    public boolean searchByName(String name){
        
        // String tempName = name;
        while (this.data !=null){
            if(this.data.Name == name){
                return true;
                
                
            }

            this.data = this.data.next;
        }
    
        return false;
    }

    public boolean searchByNumber(int num){
        
        // String tempName = num;
        while (this.data !=null){
            if(this.data.Number == num){
                return true;
                
               
            }

            this.data = this.data.next;
        }
    
        return false;
    }

    
    public void showAllContact(){
        Node tempNode = this.data;
        if(this.data == null){
            System.out.println("no Contact found!");
        }

        if(this.data!=null)

        do {
            System.out.println(tempNode.Name + " " + tempNode.Number);
            
            tempNode = tempNode.next;
            if(tempNode == null){
                break;
            }
           
        }while (tempNode!=this.data);
    }


    
    
    public String deleteContact(String name){

        if(this.data == null){
            System.out.println("no value found!");

        }


        if(this.data.Name == name){
            this.data = this.data.next;
        }else{

            Node current = this.data.next;
            Node prev = this.data;
        
       
        
        while(current!=null){
            if(current.Name== name){
                prev.next = current.next;
                break;
                
            }
            
            prev = current;
            current = current.next;

        }
    }
        --size;
        return name + "has been deleted";

    }
    public int manu()
{
    
	    System.out.println("\n\n\n\n\n");
	    System.out.println("\t\t\t\t\t--------------------------------------------\n");
	    System.out.println("\t\t\t\t\t--------------------------------------------\n");
	    System.out.println("\t\t\t\t\t|          PHONE BOOK APPLICATION          |\n");
	    System.out.println("\t\t\t\t\t--------------------------------------------\n");
	    System.out.println("\t\t\t\t\t|                                          |\n");
	    System.out.println("\t\t\t\t\t|       [1]  Add Contacts                  |\n");
	    System.out.println("\t\t\t\t\t|       [2]  Diplay All Contacts           |\n");
	    System.out.println("\t\t\t\t\t|       [3]  delete                        |\n");
	    System.out.println("\t\t\t\t\t|       [4]  Search contact                |\n");
	    
	   
	   
	    System.out.println("\t\t\t\t\t|                                          |\n");
	    System.out.println("\t\t\t\t\t--------------------------------------------\n");
	    System.out.println("\t\t\t\t\t|            [0]    Exite                  |\n");
	    System.out.println("\t\t\t\t\t--------------------------------------------\n");
	
        Scanner sc = new Scanner(System.in);
	    int a = sc.nextInt();
    
	
        
	    return a;
    }






    public static void main(String[] args) {
        phonebook ph = new phonebook();
        // ph.addNumber(1256, "name");
        // ph.addNumber(12234, "namew");
        // ph.showAllContact();
        // ph.deleteContact("name");
        // ph.showAllContact();
        // System.out.println(ph.size());
        int userInput = ph.manu();

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        do {
        
        
            if(userInput==1){
          
                System.out.println("Input number: \n ");
                int num = sc.nextInt();
            System.out.println("tInput name: \n");
            sc.nextLine();
            String name = sc.nextLine();
            sc.nextLine();
            ph.addNumber(num,name);
            System.out.println("Contact has beem saved.");
            
        
        
        }else if(userInput==2){ 
            System.out.println("\n");
            ph.showAllContact();


        }else if(userInput==3){
            System.out.println("give name of contact for deletion: ");
            String deleteContact = sc2.nextLine();
            ph.deleteContact(deleteContact);

        }else if(userInput==4){
            System.out.println("Select an option: \n 1.Search By number \n 2.Search by name ");
            int srchopt = sc.nextInt();
            if(srchopt==1){
                int numfrsrch = sc.nextInt();
                ph.searchByNumber(numfrsrch);
            if(ph.searchByNumber(numfrsrch)==true){
                    System.out.println("number saved in contact.");
                }else{
                    System.out.println("contact is not saved.");
                }
            }else if(srchopt==2){
                
                String namfrsrch = sc.nextLine();
                ph.searchByName(namfrsrch);
                if(ph.searchByName(namfrsrch)==true){
                    System.out.println("this contact is saved.");
                }else{
                    System.out.println("contact is not saved.");
                }

            }
            

        } 
        userInput = ph.manu();
    }while(userInput!=0);

      
        
    }
}
