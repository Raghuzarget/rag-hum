package library1;
import java.util.*;
interface lib
{
	void addexistingbooks();
	void addnewbooks();
}
abstract class addbooks implements lib
{
public void addexistingbooks()
{
		
}
public void addnewbooks()
{
	
}
}
class addnewbook extends addbooks
{
	Scanner s=new Scanner(System.in);
	int dept,bid,bcount;
	String bname;
	addnewbook()
	{
		System.out.println("enter the dept u need to add book 1.cse 2.mech 3.civil");
		dept=s.nextInt();
		System.out.println("enter new book id");
		System.out.println("enter new book name");
		System.out.println("enter how many books");
		if(dept==1)
		{
			bid=s.nextInt();
			bname=s.next();
			bcount=s.nextInt();
			library1.cseid[library1.csecounter]=bid;
			library1.csebooks[library1.csecounter]=bname;
			library1.csecount[library1.csecounter]=bcount;
			library1.csecounter=library1.csecounter+1;
		}
		if(dept==2)
		{
			bid=s.nextInt();
			bname=s.next();
			bcount=s.nextInt();
			library1.mechid[library1.civilcounter]=bid;
			library1.mechbooks[library1.mechcounter]=bname;
			library1.mechcount[library1.mechcounter]=bcount;
			library1.mechcounter=library1.mechcounter+1;
		}
		if(dept==3)
		{
			bid=s.nextInt();
			bname=s.next();
			bcount=s.nextInt();
			library1.civilid[library1.civilcounter]=bid;
			library1.civilbooks[library1.civilcounter]=bname;
			library1.civilcount[library1.civilcounter]=bcount;
			library1.civilcounter=library1.civilcounter+1;
		}
	}
}
class addexistingbook extends addbooks
{
	int dept,i,id;
	Scanner s=new Scanner(System.in);
	addexistingbook()
	{
		System.out.println("enter dept 1.cse 2.mech 3.civil");
		dept=s.nextInt();
		if(dept==1)
		{
			System.out.println("enter book id");
			id=s.nextInt();
			for(i=0;i<library1.csecounter;i++)
			{  
				//id=s.nextInt();
				if(id==library1.cseid[i])
				{
					library1.csecount[i]=library1.csecount[i]+1;
					break;
				}
			}
		}
	}
}
class studentdetails
{
	Scanner s=new Scanner(System.in);
	int sdept;
	HashMap<Integer,String> hm=new HashMap<Integer,String>();
	HashMap<Integer,String> hm1=new HashMap<Integer,String>();
	HashMap<Integer,String> hm2=new HashMap<Integer,String>();
	HashMap<Integer,String> hm3=new HashMap<Integer,String>();
	void csebookinfo(int key,String bookname)
	{
		hm1.put(key, bookname);
	}
	void mechbookinfo(int key,String bookname)
	{
		hm2.put(key, bookname);
	}
	void civilbookinfo(int key,String bookname)
	{
		hm3.put(key, bookname);
	}
	
	void showstudentdetails()
	{
		System.out.println(hm);
	}
	void verifystudentdetails(int k,String name)
	{
		if(hm.containsKey(k))
		{
			System.out.println("u can't take the book");
		}
		else
		{
			hm.put(k, name);
			System.out.println("enter the department u want to take the book 1.cse 2.mech 3.civil");
	        sdept=s.nextInt();
			if(sdept==1)
			{
				issuebooks i=new issuebooks();
				i.cseissuebooks(k);
			}
		}
		
		
	}
	void removedetails(int k)
	{
		hm.remove(k);
		hm1.remove(k);
		hm2.remove(k);
		hm3.remove(k);
	}
}
class bookdetails
{
	int i;
	void listallbooks()
	{
		System.out.println("computer sciene books in library are");
			for(i=0;i<library1.csecounter;i++)
			{
				System.out.println(library1.csebooks[i]);
			}
			System.out.println("mechanical books in library are");
			for(i=0;i<library1.mechcounter;i++)
			{
				System.out.println(library1.mechbooks[i]);
			}
			System.out.println("civil books in library are");
			for(i=0;i<library1.civilcounter;i++)
			{
				System.out.println(library1.civilbooks[i]);
			}
	}
	void listavailablebooks()
	{
		System.out.println("computer sciene available books in library are");
		for(i=0;i<library1.csecounter;i++)
		{
			System.out.println(library1.csebooks[i]);
			System.out.println(library1.csecount[i]);
		}
		System.out.println("mechanical books available in library are");
		for(i=0;i<library1.mechcounter;i++)
		{
			System.out.println(library1.mechbooks[i]);
			System.out.println(library1.mechcount[i]);
		}
		System.out.println("civil books available in library are");
		for(i=0;i<library1.civilcounter;i++)
		{
			System.out.print(library1.civilbooks[i] );
			System.out.println(library1.civilcount[i]);
		}
	}
	void listunavailablebooks()
	{
		studentdetails stu=new studentdetails();
		System.out.println(stu.hm1);
		System.out.println(stu.hm2);
		System.out.println(stu.hm3);
	}
	void recentbook()
	{
		System.out.println(library1.currentbook);
	}
}
class issuebooks extends bookdetails
{
	int i;
	String bookname;
	Scanner s=new Scanner(System.in);
	studentdetails stu=new studentdetails();
	void cseissuebooks(int cskey)
	{
		System.out.println("enter the cse book u want");
		bookname=s.next();
		for(i=0;i<library1.csecounter;i++)
		{
			if(library1.csebooks[i].equals(bookname))
			{
				if(library1.csecount[i]!=0)
				{
				library1.csecount[i]=library1.csecount[i]-1;
				System.out.print("take your");
				System.out.println(library1.csebooks[i]);
				stu.csebookinfo(cskey,bookname);
				}
				else
					System.out.println("your book is currently unavailable");
				break;
			}
		}
		if(i==library1.csecounter)
		{
			System.out.println("enter the right book");
			stu.removedetails(cskey);
		}
	}
	void mechissuebooks(int mechkey)
	{
		System.out.println("enter the mech book u want");
		bookname=s.next();
		for(i=0;i<library1.mechcounter;i++)
		{
			if(library1.mechbooks[i].equals(bookname))
			{
				if(library1.mechcount[i]!=0)
				{
				library1.mechcount[i]=library1.mechcount[i]-1;
				System.out.print("take your");
				System.out.println(library1.mechbooks[i]);
				stu.csebookinfo(mechkey,bookname);
				}
				else
					System.out.println("your book is currently unavailable");
				break;
			}
		}
		if(i==library1.mechcounter)
		{
			System.out.println("enter the right book");
			stu.removedetails(mechkey);
		}
		
	}
	void civilissuebooks(int civilkey)
	{
		System.out.println("enter the civil book u want");
		bookname=s.next();
		for(i=0;i<library1.csecounter;i++)
		{
			if(library1.csebooks[i].equals(bookname))
			{
				if(library1.csecount[i]!=0)
				{
				library1.civilcount[i]=library1.civilcount[i]-1;
				System.out.print("take your");
				System.out.println(library1.civilbooks[i]);
				stu.civilbookinfo(civilkey,bookname);
				}
				else
					System.out.println("your book is currently unavailable");
				break;
			}
		}
		if(i==library1.civilcounter)
		{ 
			System.out.println("enter the right book");
			stu.removedetails(civilkey);
		}
	}
}
class login
{
	Scanner s=new Scanner(System.in);
	int suid;
	String suname;
	login()
	{
	System.out.println("enter user id and username");
	suid=s.nextInt();
	suname=s.next();
	studentdetails s=new studentdetails();
	s.verifystudentdetails(suid, suname);
	}
}
class returnbook
{
	returnbook()
	{
		admin a=new admin();
		a.adminaccess();
	}
}
class admin extends bookdetails
{
	Scanner s=new Scanner(System.in);
	int adm;
	void adminaccess()
	{
     System.out.println("1.student details 2.availablebookdetails 3.nonavailable bookdetails   4.add new book to library   5.addexistingbooks");
	adm=s.nextInt();
	if(adm==1)
	{
		System.out.println("1.show student details");
		studentdetails stu=new studentdetails();
		System.out.println(stu.hm);
	}
	if(adm==2)
	{
		super.listavailablebooks();
	}
	if(adm==3)
	{
		super.listunavailablebooks();
	}
	if(adm==4)
	{
	addnewbook anb=new addnewbook();
	}
	if(adm==5)
	{
	addexistingbook aeb=new addexistingbook();	
	}
	}
}
public class library1 
{
	static String currentbook,currentstudent;
	static int csecounter,mechcounter,civilcounter;
	static int cseid[]=new int[1000];
	static int mechid[]=new int[1000];
	static int civilid[]=new int[1000];
	static String csebooks[]=new String[1000];
	static String mechbooks[]=new String[1000];
	static String civilbooks[]=new String[1000];
	static int csecount[]=new int[1000];
	static int mechcount[]=new int[1000];
	static int civilcount[]=new int[1000];
	public static void main(String args[])
	{   
		Scanner s=new Scanner(System.in);
		int i,acc;
		System.out.println("enter the how many cse books want to add");
		library1.csecounter=s.nextInt();
		System.out.println("enter cse book id,name and how many books");
		for(i=0;i<library1.csecounter;i++)
		{
			cseid[i]=s.nextInt();
			csebooks[i]=s.next();
			csecount[i]=s.nextInt();
		}
		System.out.println("enter the how many Mechanical books want to add");
		library1.mechcounter=s.nextInt();
		System.out.println("enter mech book id,name and how many books");
		for(i=0;i<library1.mechcounter;i++)
		{
			mechid[i]=s.nextInt();
			mechbooks[i]=s.next();
			mechcount[i]=s.nextInt();
		}
		System.out.println("enter the how many civil books want to add");
		library1.civilcounter=s.nextInt();
		System.out.println("enter civil book id,name and how many books");
		for(i=0;i<library1.civilcounter;i++)
		{
			civilid[i]=s.nextInt();
			civilbooks[i]=s.next();
			civilcount[i]=s.nextInt();
		}
		while(true)
		{
			System.out.println("1.admin   2.taking a book   3.return a book    4.exit");
			acc=s.nextInt();
			if((acc==1)||(acc==3))
			{
				admin a=new admin();
				a.adminaccess();
			}
			if(acc==2)
			{
				login l=new login();
			}
			if(acc==4)
				break;
		}
	}
}
