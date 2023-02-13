/*
SECTION 1 
GROUP MEMBERS           ID No.
1.JIBRIL ARBICHO        RU2101/13			
2.BEKALUU ENDRIAS	RU2501/13			
3.YOHANNES DEREJE	RU3566/13			
4.YARED BIRIHANU	RU2877/13			
5.SARON HAILEMICHAEL	RU3638/13			
*/
package CriminalInformationSystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

class admin {
   
    Scanner sc=new Scanner(System.in);
  private String adminUsername;  
  private String adminpassword;
  private String policeName;
  private String policeFname;
  private String policeID;
  private String policePassword;
  String adminfile="admin.txt";
  String policefile="police.txt";
  public void register_as_admin(){
     
           try{  
             admin cril=new admin();
        System.out.println("Please enter your user id");
        cril.adminUsername = this.sc.nextLine();
         while (cril.adminUsername == null || cril.adminUsername.isEmpty()) {
           cril.adminUsername = sc.nextLine().trim();
            System.out.println("Please enter the ID :");
            cril.adminUsername = sc.nextLine().trim();
            if (cril.adminUsername.isEmpty()) {
                System.out.println("Id is necessary, please try again.");
            }
    }
        System.out.println("Please enter your password");
        cril.adminpassword = this.sc.nextLine();
        while (cril.adminpassword== null || cril.adminpassword.isEmpty()) {
            cril.adminpassword = sc.nextLine().trim();
            System.out.println("Please enter the password:");
            cril.adminpassword = sc.nextLine().trim();
            if (cril.adminpassword.isEmpty()) {
                System.out.println("Password is necessary, please try again.");
            }
    }
       adreg_file(cril);    
        }
        catch(Exception e){
        e.printStackTrace();
    }
    }  
   public void adreg_file(admin cril){
     try{
         FileWriter nit = new FileWriter(adminfile);
 nit.write("*USER NAME ,**PASSSWORD****************\n");        
nit.write(cril.adminUsername+",");
nit.write(cril.adminpassword+"\n");
nit.write("************************************\n");
        System.out.println("Registeration Succesful. Now you can login.");
        nit.close();   
       }   
       catch(NullPointerException e){
            System.out.println("the file is null");   
        }  
       catch(Exception e){
        e.printStackTrace();   
       }
        loginasadmin();
       
   }  
  
   public void loginasadmin(){
     adminlog(adminfile);     
   }
   public void adminlog(String adminfile){
         try{
          System.out.println("Please enter your admin usernmae ");
          String adusername = sc.nextLine();
           while (adusername == null || adusername.isEmpty()) {
           
            System.out.println("Please enter your admin username :");
            adusername = sc.nextLine().trim();
            if (adusername.isEmpty()) {
                System.out.println("Id is necessary, please try again.");
            }
    }
        System.out.println("Please enter your password");
        String adpassword = sc.nextLine();
       while ( adpassword == null ||  adpassword.isEmpty()) {
          
            System.out.println("Please enter the password:");
             adpassword= sc.nextLine().trim();
            if ( adpassword.isEmpty()) {
                System.out.println("Password is necessary, please try again.");
            }
    }
         FileInputStream j = new FileInputStream(adminfile);
       Scanner scanii=new Scanner(j);
                 String jir;
                 boolean found = false;
                while (scanii.hasNextLine()) {
               jir=scanii.nextLine();
                String[] credentials = jir.split(",");
                  if(credentials[0].matches(adusername) && credentials[1].matches(adpassword)){
                    found = true;
                    break;} 
                }     
             if(found){
                System.out.println("Welcome! You are logged in.");
               adminmenu();
            } else {
                System.out.println("Invalid username or password. Please try again.");
                adminlog(adminfile);
            }
      j.close();
      } 
      catch(NullPointerException e){
            System.out.println("the file is null");   
        }
      catch(FileNotFoundException e){
          System.out.println("the file not found");   
      }
     catch(Exception e){
       e.printStackTrace();
     }
       
       
   }
   public void adminmenu(){
    System.out.println("WELCOME TO CRIMINAL INFORMATION SYSTEM");
  System.out.println("#####################################################################");
  System.out.println("######   ENTER YOUR CHOICE                           ################");
  System.out.println("######   1.To add police  Officers                   ################");
  System.out.println("######   2.To display Police Officers Information    ################");
  System.out.println("######   3.To display Criminals Information          ################");
  System.out.println("######   4.To search Criminals BY ID                 ################");
  System.out.println("######   5.to exit                                   ################");
  System.out.println("#####################################################################");
     System.out.println("ENTER YOUR CHOICE");
     String a=sc.nextLine();
        int c=Integer.parseInt(a);    
   while(c!=5){ 
       switch(c){
           
       case 1:
           try{
              
         admin  crimi=new  admin();  
       System.out.println("enter the police officier first name "); 
     crimi.policeName=this.sc.nextLine(); 
       while (crimi.policeName == null || crimi.policeName.isEmpty()) {
            crimi.policeName= sc.nextLine().trim();
            System.out.println("Please enter the  first name:");
            crimi.policeName = sc.nextLine().trim();
            if (crimi.policeName.isEmpty()) {
                System.out.println("police officer First name is necessary, please try again.");
            }
    }  
      
       System.out.println("enter the police officier father name "); 
     crimi.policeFname=this.sc.nextLine(); 
       while (crimi.policeFname == null || crimi.policeFname.isEmpty()) {
            crimi.policeFname= sc.nextLine().trim();
            System.out.println("Please enter the  first name:");
            crimi.policeFname = sc.nextLine().trim();
            if (crimi.policeFname.isEmpty()) {
                System.out.println(" police officer Father name is necessary, please try again.");
            }
    } 
               System.out.println("MAKE THE POLICE OFFICER USER NAME AND PASSWORD");
        System.out.println("enter the police officier username "); 
     crimi.policeID=this.sc.nextLine(); 
       while (crimi.policeID == null || crimi.policeID.isEmpty()) {
            crimi.policeID= sc.nextLine().trim();
            System.out.println("Please enter the  first name:");
            crimi.policeID = sc.nextLine().trim();
            if (crimi.policeID.isEmpty()) {
                System.out.println(" police officer Father name is necessary, please try again.");
            }
    } 
          
        System.out.println("enter the police officier password "); 
     crimi.policePassword=this.sc.nextLine(); 
       while (crimi.policePassword == null || crimi.policePassword.isEmpty()) {
            crimi.policePassword= sc.nextLine().trim();
            System.out.println("Please enter the  first name:");
            crimi.policePassword = sc.nextLine().trim();
            if (crimi.policePassword.isEmpty()) {
                System.out.println(" police officer Father name is necessary, please try again.");
            }
    } 
       polfile(crimi);
       }
       catch(Exception e){
               e.printStackTrace();
               }
       break;
       case 2:
        display_pol();
        break;
       case 3:
           dis();
           break;
       case 4:
           disbyid();
           break;
       case 5:
           System.out.println("Good Bye!!");
           break;
       default:
           System.out.println("INVALID CHOICE ");   
   }
       adminmenu();
       System.out.println("ENTER YOUR CHOICE\n");
    c=Integer.parseInt(a);
    
   }
   }
   public void dis(){
      CriminalInformationSystem wabiii=new CriminalInformationSystem(); 
     wabiii.display12(); 
   }
   public void disbyid(){
       CriminalInformationSystem wabii1=new CriminalInformationSystem(); 
     wabii1.display123();   
   }
   public void display_pol(){
   try { 
       BufferedReader boore = new BufferedReader(new FileReader(policefile));
                 String line;
                while ((line = boore.readLine()) != null) {
               System.out.println(line);}             
boore.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
       
   }
  public void polfile(admin crimi){
      try{
         FileWriter wabi = new FileWriter(policefile,true);
 wabi.write("\n*******************************************************\n");        
wabi.write("FIRST  NAME------------------>"+crimi.policeName+"\n");
wabi.write("FTAHER NAME------------------>"+crimi.policeFname+"\n");
wabi.write("POLICE USERNAME AND PASSWORD-------------->"+crimi.policeID+",");
wabi.write(crimi.policePassword+"\n");
wabi.write("************************************************************\n");
        System.out.println("Registeration Succesful.");
        wabi.close();   
       }   
       catch(NullPointerException e){
            System.out.println("the file is null");   
        }  
       catch(Exception e){
        e.printStackTrace();   
       }
      
      
  } 
  
}  

 public class CriminalInformationSystem extends admin  {
    String file="criminal.txt";  
Scanner scan=new Scanner(System.in);
private String Id;
    private String name;
    private String fname;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String sex;
    private String address;
    private int age;
   private int arresYear;
   private int arresMonth;
   private int arresDay;
    private String crime;
   private String details;
    private String username ;
  private  String password;
  private String maritalStatus;
    private String legalStatus;
    private String healthStatus;
    private String sentenceDuration;
  

    public void login()
    {  
        log_file(policefile); 
    }
     int chance=0;
   public void log_file( String policefile){
      
      try{
          System.out.println("Please enter your username  ");
          String uusername = scan.nextLine();
           while (uusername == null || uusername.isEmpty()) {
            System.out.println("Please enter the username :");
            uusername = scan.nextLine().trim();
            if (uusername.isEmpty()) {
                System.out.println("usernameis necessary, please try again.");
            }
    }
        System.out.println("Please enter your password");
        String ppassword = scan.nextLine();
       while ( ppassword == null ||  ppassword.isEmpty()) {
           //  ppassword= scan.nextLine().trim();
            System.out.println("Please enter the password:");
             ppassword= scan.nextLine().trim();
            if ( ppassword.isEmpty()) {
                System.out.println("Password is necessary, please try again.");
            }
    }
         FileInputStream k = new FileInputStream(policefile);
       Scanner scani=new Scanner(k);
                 String lin;
                 boolean found = false;
                while (scani.hasNextLine()) {
               lin=scani.nextLine();
                String[] credentials = lin.split(",");
                  if(credentials[0].matches("POLICE USERNAME AND PASSWORD-------------->"+uusername) && credentials[1].matches(ppassword)){
                    found = true;
                    break;} 
                }     
             if(found){
                System.out.println("Welcome! You are logged in.");
                menu();
            } else {
                  chance++;
                  if(chance==1){
                System.out.println("Invalid username or password. Please try again.");
                 System.out.println("YOU HAVE ONLY 3 CHANCE");
               
                log_file(policefile);
                  }
                  else if(chance==2){
                    System.out.println("Invalid username or password. Please try again.");
                    System.out.println("YOU HAVE ONLY 2 CHANCE"); 
                    log_file(policefile);
                }
                else if(chance==3){
                    System.out.println("Invalid username or password. Please try again.");
                    System.out.println("YOU HAVE ONLY 1 CHANCE"); 
                    log_file(policefile);
                }
                else{
     System.out.println("YOU TRIED MORE THAN THREE TIMES YOU ARE NOT REGISTERED OR NOT AUTHORIZED TO LOGIN ");    
                return;
                }
                   
            }
      k.close();
      } 
      catch(NullPointerException e){
            System.out.println("the file is null");   
        }
      catch(FileNotFoundException e){
          System.out.println("the file not found");   
      }
     catch(Exception e){
       e.printStackTrace();
     }   
    }
 public   void menu(){
     try{
          System.out.println("WELCOME TO CRIMINAL INFORMATION SYSTEM");
  System.out.println("#######################################################################");
  System.out.println("###############   ENTER YOUR CHOICE                    ################");
  System.out.println("###############    1.To add criminal                   ################");
  System.out.println("###############    2.To display information            ################");
  System.out.println("###############    3.To Search criminal information    #################");
  System.out.println("###############    -1.to exit                          #################");
  System.out.println("########################################################################");
   Scanner scan=new Scanner(System.in);
     System.out.println("ENTER YOUR CHOICE");
     String a=scan.nextLine();
        int c=Integer.parseInt(a);    
   while(c!=-1){
    switch(c){
     case 1:   
        try{   
       CriminalInformationSystem  crimia=new  CriminalInformationSystem();  
       System.out.println("enter the criminal Id ");
       
     crimia.Id=this.scan.nextLine(); 
       while (crimia.Id == null || crimia.Id.isEmpty()) {
            crimia.Id = scan.nextLine().trim();
            System.out.println("Please enter the ID first name:");
            crimia.Id = scan.nextLine().trim();
            if (crimia.Id.isEmpty()) {
                System.out.println("Id is necessary, please try again.");
            }
    }
        System.out.println("enter the criminal first name"); 
     crimia.name=this.scan.nextLine();
        while (crimia.name == null || crimia.name.isEmpty()) {
            crimia.name = scan.nextLine().trim();
            System.out.println("Please enter the criminal's first name:");
            crimia.name = scan.nextLine().trim();
            if (crimia.name.isEmpty()) {
                System.out.println("Name is necessary, please try again.");
            }
    }   
  System.out.println("enter the criminal father name"); 
     crimia.fname=this.scan.nextLine();
     while (crimia.fname == null || crimia.fname.isEmpty()) {
            crimia.fname = scan.nextLine().trim();
            System.out.println("Please enter the criminal's father name:");
            crimia.fname = scan.nextLine().trim();
            if (crimia.fname.isEmpty()) {
                System.out.println("Father name is necessary, please try again.");
            }
    }

     System.out.println("Enter the criminal sex M for Male or F for female ):");
String sex = this.scan.nextLine();
while (!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F")) {
    System.out.println("Invalid input. Please enter M or F:");
    sex = this.scan.nextLine();
}
crimia.sex = sex;
 
       System.out.println("enter the criminal address region/zone/woreda/kebele");
     crimia.address=this.scan.nextLine();
     while (crimia.address == null || crimia.address.isEmpty()) {
            crimia.address = scan.nextLine().trim();
            System.out.println("Please enter the criminal address region/zone/woreda/kebele:");
            crimia.address = scan.nextLine().trim();
            if (crimia.address.isEmpty()) {
                System.out.println("Address is necessary, please try again.");
            }
    }
        System.out.println("Enter your birth year (YYYY) ");
          crimia.birthYear =this.scan.nextInt();
           Calendar toda = Calendar.getInstance();
         while ( crimia.birthYear < 1000 || crimia.birthYear >toda.get(Calendar.YEAR)) {
    System.out.println("Invalid birth year, please enter a 4-digit year (YYYY)");
    crimia.birthYear = scan.nextInt();
        
}
//crimia.birthYear = birthYear;
        System.out.println("Enter the criminal birth month (MM) ");
        crimia.birthMonth = this.scan.nextInt() ;
         this.scan.nextLine();
         while (crimia.birthMonth < 0 || crimia.birthMonth >12) {
    System.out.println("Invalid birth month, please enter a  month (MM)");
    crimia.birthMonth = scan.nextInt();
}
        System.out.println("Enter the criminal birth day (DD) ");
        crimia.birthDay = this.scan.nextInt();
        this.scan.nextLine();
        while (crimia.birthDay < 0 || crimia.birthDay >31) {
    System.out.println("Invalid birth day, please enter a  day (MM)");
   crimia.birthDay = scan.nextInt();
}
      
        
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(crimia.birthYear, crimia.birthMonth - 1, crimia.birthDay);

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        
         crimia.age=age;
         System.out.println("enter the  criminal marital status");
      crimia.maritalStatus=this.scan.nextLine();
       while (crimia.maritalStatus == null || crimia.maritalStatus.isEmpty()) {
            crimia.maritalStatus = scan.nextLine().trim();
            System.out.println("Please enter the the criminal marital status :");
            crimia.maritalStatus = scan.nextLine().trim();
            if (crimia.maritalStatus.isEmpty()) {
                System.out.println("marital status is necessary, please try again.");
            }
    }
       System.out.println("enter the  criminal health status");
      crimia.healthStatus=this.scan.nextLine();
       while (crimia.healthStatus == null || crimia.healthStatus.isEmpty()) {
            crimia.healthStatus = scan.nextLine().trim();
            System.out.println("Please enter the criminal helath status:");
            crimia.healthStatus = scan.nextLine().trim();
            if (crimia.healthStatus.isEmpty()) {
                System.out.println("health status  is necessary, please try again.");
            }
    }
       System.out.println("enter the  criminal legal status");
      crimia.legalStatus=this.scan.nextLine();
       while (crimia.legalStatus == null || crimia.legalStatus.isEmpty()) {
            crimia.legalStatus = scan.nextLine().trim();
            System.out.println("Please enter the criminal legal status:");
            crimia.legalStatus = scan.nextLine().trim();
            if (crimia.legalStatus.isEmpty()) {
                System.out.println(" legal status is necessary, please try again.");
            }
    }
        
      System.out.println("enter the Year  the criminal was arrested");
      crimia.arresYear=this.scan.nextInt();
       while ( crimia.arresYear < 1000 || crimia.arresYear >toda.get(Calendar.YEAR)) {
    System.out.println("Invalid arrested year, please enter a 4-digit year (YYYY)");
    crimia.arresYear = scan.nextInt();
        
}
        System.out.println("Enter  the month the criminal was arrested  ");
        crimia.arresMonth = this.scan.nextInt() - 1 ;
         this.scan.nextLine();
         while (crimia.arresMonth < 1 || crimia.arresMonth >12) {
    System.out.println("Invalid  month, please enter a  month ");
    crimia.arresMonth = scan.nextInt();
}
  System.out.println("Enter the day the criminal was arrested ");
        crimia.arresDay = this.scan.nextInt();
        this.scan.nextLine();
        while (crimia.arresDay < 1 || crimia.arresDay >31) {
    System.out.println("Invalid  day, please enter a  day ");
   crimia.arresDay = scan.nextInt();
}
       System.out.println("enter the  criminal sentence duration year/month/day ");
      crimia.sentenceDuration=this.scan.nextLine();
     while (crimia.sentenceDuration == null || crimia.sentenceDuration.isEmpty()) {
            crimia.sentenceDuration = scan.nextLine().trim();
            System.out.println("Please enter the the criminal sentence duration year/month/day:");
            crimia.sentenceDuration = scan.nextLine().trim();
            if (crimia.sentenceDuration.isEmpty()) {
                System.out.println("sentence duration is necessary, please try again.");
            }
    }
       
      System.out.println("enter the the types of crime");
      crimia.crime=this.scan.nextLine();
       while (crimia.crime == null || crimia.crime.isEmpty()) {
            crimia.crime = scan.nextLine().trim();
            System.out.println("Please enter the criminal's first name:");
            crimia.crime = scan.nextLine().trim();
            if (crimia.crime.isEmpty()) {
                System.out.println("Name is necessary, please try again.");
            }
    }
      System.out.println("enter the the deatils of the of crime");
      crimia.details=this.scan.nextLine();
       while (crimia.details == null || crimia.details.isEmpty()) {
            crimia.details = scan.nextLine().trim();
            System.out.println("Please enter the criminal crime details :");
            crimia.details = scan.nextLine().trim();
            if (crimia.details.isEmpty()) {
                System.out.println(" is Crime deatails is necessary, please try again.");
            }
    }   
      write_to_file(crimia);
        }
       catch(InputMismatchException e){
           System.out.println("please enter the correct input");  
       }
        catch(NumberFormatException e){
            System.out.println("please enter the number only"); 
            menu();
        }
         catch(Exception e){
          e.printStackTrace(); 
       }
    break;    
     case 2:

      display(file);   
       
         break;
    case 3:
  
                        display_by_id(file);
        break;
       
     default:
      System.out.println("WRONG CHOICE");     
   } 
  menu();
    System.out.println("ENTER YOUR CHOICE");
   c= scan.nextInt();     
 }
 } 
  catch(NumberFormatException e){
      System.out.println("PLEASE ENTER THE NUMBER ");
    }   
 catch(Exception e){
    e.printStackTrace();
    } 
     } 
 public void display12(){
    display(file);   
 }
 public void display123(){
    display_by_id(file);   
 }
public void write_to_file(CriminalInformationSystem crimia){
        try{    
             FileWriter fil = new FileWriter(file,true);
    fil.write("\n***********************************************************************************************************************************\n");
  
    fil.write("ID-------------------------------------->"+crimia.Id+"\n");
    fil.write("FIRST NAME------------------------------>"+crimia.name+"\n");
    fil.write("FATHER NAME----------------------------->"+crimia.fname+"\n");
    fil.write("SEX------------------------------------->"+crimia.sex.toUpperCase()+"\n");
    fil.write("REGION/ZONE/WOREDA/KEBELE--------------->"+crimia.address+"\n");
    fil.write("BIRTH DATE------------------------------>"+crimia.birthDay+"/"+crimia.birthMonth+"/"+crimia.birthYear+"\n");
    fil.write("AGE------------------------------------->"+crimia.age+"\n");
    fil.write("MARITAL STATUS-------------------------->"+crimia.maritalStatus+"\n");
    fil.write("HEALTH  STATUS-------------------------->"+crimia.legalStatus+"\n");
    fil.write("LEGAL STATUS---------------------------->"+crimia.maritalStatus+"\n");
    fil.write("CRIMINAL ARRESTED YEAR/MONTH/DAY-------->"+crimia.arresYear+"/"+crimia.arresMonth+"/"+crimia.arresDay+"\n");
    fil.write("SENTENCE DURATION YEAR/MONTH/DAY-------->"+crimia.sentenceDuration+"\n");
    fil.write("CRIME TYPE------------------------------>"+crimia.crime+"\n");
    fil.write("CRIME DETAILS--------------------------->"+crimia.details+"\n");
    fil.write("**********************************************************************************************************************************\n");
        fil.close();
            System.out.println("writing to file is succesfully done");
        }
    catch (FileNotFoundException e) {
         System.out.println("file you want write not exist"); 
     }
        catch(NullPointerException e){
            System.out.println("the file is null");   
        }
catch (Exception e) {
   e.printStackTrace();
}   
}
public void display(String file){
  try { 
       BufferedReader ko = new BufferedReader(new FileReader(file));
                 String line;
                while ((line = ko.readLine()) != null) {
               System.out.println(line);}             
ko.close();
        }catch(Exception e) {
            e.printStackTrace();
        }    
}
 public void display_by_id(String file) {
    System.out.println("Enter the Id to be Searched: ");
    String searchId = scan.nextLine();

    try {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String lin = null;
        int count = 0;
        boolean found = false;

        while ((lin = reader.readLine()) != null) {
            if (lin.contains(searchId)) {
                System.out.println("THERE IS AN EXISTING PERSON WITH THE SEARCHED ID");
                System.out.println(lin);
                found = true;
                count = 0;
            } else if (found && count < 13) {
                System.out.println(lin);
                count++;
            } else if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("THERE IS NO SUCH ID YOU INSERTED");
        }

        reader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        CriminalInformationSystem wabii = new CriminalInformationSystem();
        System.out.println("Welcome To Criminal Information System");
     try{
        do
        {   
            System.out.println("1. To Register As Admin");
            System.out.println("2. To Login As Admin");
            System.out.println("3. To Login As Police Officier"); 
            System.out.println("4. Exit");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1: wabii.register_as_admin();
                         
                        break;
                case 2: wabii.loginasadmin(); 
                        break;
                case 3: 
                        wabii.login();
                        break; 
                case 4:
                    System.out.println("GOOD BYE!!!");
                    break;
                default: 
         System.out.println("Invalid choice, please try again.");
   }
   }while(choice!=4);    
     }
     catch(Exception e){
         e.printStackTrace();
     }
    }    
} 
 
