package library;
import java.util.*;
interface lib
{
	void addexistingbooks();
	void addnewbooks();
}
abstract class adbooks implements lib
{
public void addexistingbooks()
{
		
}
public void addnewbooks()
{
	
}
}
class addingnewbooks extends adbooks
{   Scanner s=new Scanner(System.in);
    String n;
	static String newbooks[]=new String[1000];
	static int newbookid[]=new int[1000];
	static int newbooknum[]=new int[1000];
	static int counter;
	int y,t,id;
	addingnewbooks()
	{
		y=s.nextInt();
System.out.println("enter new book name");
n=s.next();
System.out.println("enter how many books");
t=s.nextInt();
System.out.println("enter new bookid");
id=s.nextInt();
addingnewbooks.newbooks[addingnewbooks.counter]=n;
addingnewbooks.newbookid[addingnewbooks.counter]=id;
addingnewbooks.newbooknum[addingnewbooks.counter]=t;
counter++;
}
	}
class addingexistingbooks extends adbooks
{
	addingexistingbooks()
	{
	bookreturn b=new bookreturn();
}
}
class userdetails
{
int r;	
static int count;
static int userid[]=new int[1000];
static String username[]=new String[1000];	
static String userbook[]=new String[1000];
void showuserdetails()
	{
		System.out.println("userid and username are");
		for(r=0;r<count;r++)
		{
			System.out.print(userdetails.userid[r]);
			System.out.println(userdetails.username[r]);
			System.out.println(userdetails.userbook[r]);
		}
	}
	void adduserdetails(int ud,String name)
	{
		userid[count]=ud;
		username[count]=name;
		count++;
	}
 void verifydetails(int ud,String nam)
{
	 int t;
	for(r=0;r<count;r++)
	{
		if((userid[r]==ud)&&((userid[r+1]!=0)&&(userid[r+1]!=ud)))
		{
			t=0;
			break;
		}
	}
	if(r==count)
	{
		userdetails user=new userdetails();
		user.adduserdetails(ud,nam);
  }	
	else
	{
		System.out.println("u can't take the book");
	}
	
}
}
class login
{
login()
{
	Scanner s=new Scanner(System.in);
	System.out.println("enter userid and username");
	int userid,i;
	String uname;
	userid=s.nextInt();
	uname=s.next();
	System.out.println(userid);
	System.out.println(uname);
	System.out.println(" 1.taking book 2.bookreturn 3.adminlook");
	i=s.nextInt();
     if(i==1)
	{
    	 userdetails u=new userdetails();
    	 u.verifydetails(userid, uname);
          books t=new books();
          t.depart();
	}
 	    if(i==2)
 	     {
           bookreturn b=new bookreturn();
 		
 }
	if(i==3)
 	{
              admin adm=new admin();
 		
 }
}
}
class available
{   int i;
    String t;
	String computer[]={"m1","chm","phy","m2","chm2","phy2","dpsd","ds","oops","aca","mp","dbms"};
	String mechanical[]={"mech1","mech2","mech3","mech4","mech5","mech6","mech7","mech8","mech9","mech10","mech11","mech12","mech13","mech14","mech15","mech16"};
	String civil[]={"civil1","civil2","civil3","civil4","civil5","civil6","civil7","civil8","civil9","civil10","civil11","civil12","civil13","civil14","civil15","civil16"};
	String cseissue(String book)
	{
     for(i=0;i<12;i++)
     {
    	  if(computer[i].equals(book))
    	 {
    		 if(library.cs[i]!=0)
    		 {
    			 library.cs[i]=library.cs[i]-1;
    			 userdetails.userbook[userdetails.count-1]=computer[i];
    	         t="get your book";
    	        break;
    	        }
  
	}
     }
      	 if(i==12)
    	 {
      		 if(addingnewbooks.counter==0)
      		 {
      			t="your book is not available";
      		 }
      		 else
      		 {
      		 for(i=0;i<addingnewbooks.counter;i++)
              {
      			 if(addingnewbooks.newbooks[i].equals(book))
      				 {t="get your book";
      				userdetails.userbook[userdetails.count-1]=computer[i];
      				addingnewbooks.newbooknum[i]=addingnewbooks.newbooknum[i]-1;
                     break;              
                     }
      				 if(i==11)
      			 t="your book is not available";
              }
      		 
    	 }}
      	System.out.println(t);
     
        return(t);
}
	String mechissue(String book)
	{
		for(i=0;i<12;i++)
	     {
	    	 if(mechanical[i].equals(book))
	    	 {
	    		 if(library.me[i]!=0)
	    		 {
	    	     t="get your book";
	    	     userdetails.userbook[userdetails.count-1]=mechanical[i];
	    	     break;
	    	     }
	    	 }
	     }
		if(i==12)
	        	 {
	          		 if(addingnewbooks.counter==0)
	          		 {
	          			t="your book is not available";
	          		 }
	          		 else
	          		 {
	          		 for(i=0;i<addingnewbooks.counter;i++)
	                  {
	          			 if(addingnewbooks.newbooks[i].equals(book))
	          				 {t="get your book";
	          				addingnewbooks.newbooknum[i]=addingnewbooks.newbooknum[i]-1;
	                         break;              
	                         }
	          				 if(i==11)
	          			 t="your book is not available";
	                  }
	          		 
	        	 }
	        	        		 }
	          	System.out.println(t);
	         
	            return(t);

	   }
	String civilissue(String book)
	{
		for(i=0;i<12;i++)
	     {
	    	 if(civil[i].equals(book))
	    	 {
	    		 if(library.civ[i]!=0)
	    		 {
	    			 library.civ[i]=library.civ[i]-1;
	    	     t="get your book";
	    	     userdetails.userbook[userdetails.count-1]=civil[i];
	    	     break;
	    		 }
	    	 }
	     }
	    		 if(i==12)
	        	 {
	          		 if(addingnewbooks.counter==0)
	          		 {
	          			t="your book is not available";
	          		 }
	          		 else
	          		 {
	          		 for(i=0;i<addingnewbooks.counter;i++)
	                  {
	          			 if(addingnewbooks.newbooks[i].equals(book))
	          				 {t="get your book";
	          				addingnewbooks.newbooknum[i]=addingnewbooks.newbooknum[i]-1;
	                         break;              
	                         }
	          				 if(i==11)
	          			 t="your book is not available";
	                  }
	          		 
	        	 }}
	          	System.out.println(t);
	         
	            return(t);

	}
	     }
	
class bookdetails extends available
{
	Scanner s=new Scanner(System.in);
	void bookdetails()
	{
		int dep,i;
		System.out.println("Enter your department 1.cse 2.mech 3.civil");
		dep=s.nextInt();
		if(dep==1)
		{
			System.out.println("existing cse books are:");
			for(i=0;i<12;i++)
			{
				System.out.print(super.computer[i]);
				System.out.println(library.cs[i]);
			}
		}
		if(dep==2)
		{
			System.out.println("existing mech books are");
			for(i=0;i<12;i++)
			{
				System.out.print(super.mechanical[i]);
				System.out.println(library.me[i]);
			}
		}
		if(dep==3)
		{
			System.out.println("existing civil books are");
			for(i=0;i<12;i++)
			{
				System.out.print(super.civil[i]);
				System.out.println(library.civ[i]);
			}
		}
		}
}
class admin  extends bookdetails
{
	int id,dum;
	Scanner s=new Scanner(System.in);
    admin()
	{
    	System.out.println("1.add books  2.user details 3.bookdetails");
    	dum=s.nextInt();
		if(dum==1)
		   {
			System.out.println("enter bookid");
			id=s.nextInt();
			   addbooks add=new addbooks(id);
		   }
		if(dum==2)
		   {
			userdetails u=new userdetails();
			u.showuserdetails();
		   }
		if(dum==3)
		{
			super.bookdetails();
		}
		}
    }
class addbooks
{
	addbooks(int t)
	{
		int i;
		t=t/100;
	if(t<12)
	library.cs[t]=library.cs[t]+1;
	if((t>11)&&(t<24))
	{   
		t=t-12;
		library.me[t]=library.me[t]+1;
	}
	if(t>23)
	{
		t=t-23;
		library.civ[t]=library.civ[t]+1;
	}
	else
	{ t=t*100;
		for(i=0;i<addingnewbooks.counter;i++)
		{
			if(t==addingnewbooks.newbookid[i])
			{
				addingnewbooks.newbooknum[i]=addingnewbooks.newbooknum[i]+1;
		}
			}
	}
	}
}
class books extends bookdetails
{
	Scanner s=new Scanner(System.in);
	void depart()
	{
	 System.out.println("enter which department 1.cse 2.mech 3.civil 4.bookdetails");
	 int dep;
	dep=s.nextInt();
	semester d=new semester();
	if(dep==1)
	{
	d.cse();
	}
	if(dep==2)
	{
	d.mech();
	}
	if(dep==3)
	{
	d.civil();
	}
	if(dep==4)
	{
	super.bookdetails();
	}
	}
	}
class semester
{
	
	Scanner s=new Scanner(System.in);
	available a=new available();
	int sem;
	void cse()
	{
    String books;
    System.out.println("enter book");
    books=s.next();
	a.cseissue(books);
	}
	void mech()
	{
    String books;
    System.out.println("enter book");
    books=s.next();
	a.mechissue(books);
	}
	void civil()
	{
    String books;
    System.out.println("enter book");
    books=s.next();
	a.civilissue(books);
	}
	}
class bookreturn 
{
	int bookid;
	Scanner s=new Scanner(System.in);
	bookreturn()
	{
		System.out.println("enter bookid");
		bookid=s.nextInt();
		admin a=new admin();
	}
}
public class library
{
	/*static {
		System.out.println("library managment system");
	}*/
    static int val;
    static int cs[]=new int[60];
    static int csid[]=new int[60];
	static int me[]=new int[60];
	static int meid[]=new int[60];
	static int civ[]=new int[60];
	static int civid[]=new int[60];
	public static void main(String[] args)  throws Exception
	{
		for(val=0;val<36;val++)
		{
			if(val<12)
			{
				cs[val]=20;
				csid[val]=(val+1)*100;
			}
			if((val>23)&&(val<36))
			{
				civ[val-24]=20;
				civid[val-24]=(val+1)*100;
			}
			if((val>11)&&(val<23))
			{
				me[val-12]=20;
				meid[val-12]=(val+1)*100;
			}
		}
		while(true)
		{ 
			Scanner s=new Scanner(System.in);
			int number,k;
			System.out.println("enter number 1.to enter library  2.admin 3.to exit library");
			number=s.nextInt();
			if(number==1)
			{
			login l=new login();
			}
			if(number==2)
			{
				admin a=new admin();
			}
			if(number==3)
			{
				break;
			}
		 }
		
	      }

}

