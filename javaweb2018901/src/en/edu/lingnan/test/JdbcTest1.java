//package en.edu.lingnan.test;
//
//import java.util.Scanner;

//import en.edu.lingnan.Dao.AdminiDao;
//import en.edu.lingnan.Dao.BooksDao;
//import en.edu.lingnan.Dao.BorrowBookDao;
//import en.edu.lingnan.Dao.StudentDao;
//import en.edu.lingnan.Dto.BooksDto;
//import en.edu.lingnan.Dto.ClassDto;

//public class JdbcTest1 {
//	public static void main(String[] args) {
//		int i,k;
//		BooksDao b =new BooksDao();
//		StudentDao s= new StudentDao();
//		boolean fg = false;
//		BorrowBookDao bb =new BorrowBookDao();
//		AdminiDao a = new AdminiDao();
//		Scanner input = new Scanner(System.in);
//		while(true)
//		{
//			System.out.println("              1.ע��              ");       
//			System.out.println("              2.��¼             ");
//			System.out.println("===========������1��2 ");
//			int l = input.nextInt();
//			if(l==1)
//			{
//				a.addAdminiInfo();
//				System.out.println("ע��ɹ����ֽ������Ա����..."); break;
//			}
//			else {
//			//if(a.LoginAdminiInfo("1","2"))
//			{
//				break;
//			}
//			else{
//	    		System.out.println("����������������룡");
//	    	}
//			}
//		}
//		while(true)
//		{ 
//			System.out.println("*********��ӭ����ʦͼ��ݹ���ϵͳ********");
//			System.out.println("              1.ͼ����Ϣ              ");       
//			System.out.println("              2.������Ϣ              ");        
//			System.out.println("              3.����Ա��Ϣ            ");       
//			System.out.println("              4.������Ϣ              ");           
//			System.out.println("              5.������Ϣ              ");           
//			System.out.println("              6.���ڷ�������⳥��Ϣ");        
//			System.out.println("              0.�˳�                  ");            
//			System.out.println("              ������ѡ���ܵ����   :");	
//			do{
//			System.out.println("������0����6"); 
//	    	System.out.println("**************************************************"); 
//	    	i = input.nextInt();
//			}while(i<0||i>6);
//	    	switch(i)
//	    	{
//	    	//�˳�
//	    	case 0:System.out.println("���Ѿ��˳�ϵͳ��"); return;  
//	    	//ͼ����Ϣ
//    		case 1:   
//    			System.out.println("*************ͼ����Ϣ:      ");        
//    	    	System.out.println("   1. ��ѯͼ����Ϣ:      ");       
//    	    	System.out.println("   2. ����ͼ����Ϣ:      ");       
//    	    	System.out.println("   3. ɾ��ͼ����Ϣ:      ");       
//    	    	System.out.println("   4. �޸�ͼ����Ϣ:      ");         
//    	    	int a1=input.nextInt();               
//    	    	switch(a1)          
//    	    	{                  
//    	    	case 1:            
//    	    		System.out.println("*************��ӭ����ͼ����Ϣ��ѯϵͳ:      "); 
//    	    		System.out.println("   1. ��������ѯͼ����Ϣ:      ");    
//    	    		System.out.println("   2. ��id��ѯͼ����Ϣ:      "); 
//    	    		int b1=input.nextInt();	
//    	    		switch(b1)          
//        	    	{                  
//        	    	case 1:
//        	    		b.findallBooksInfo();break;
//        	    	case 2:
//        	    		b.findBooksid();break;
//    	    		}break;
//    	    	case 2:
//    	    		System.out.println("*************��ӭ����ͼ����Ϣ����ϵͳ:      "); 
//    	    		b.addBooksInfo();break;
//    	    	case 3:
//    	    		System.out.println("*************��ӭ����ͼ����Ϣɾ��ϵͳ:      "); 
//    	    		b.deleteBooksid();break;
//    	    	case 4:
//    	    		System.out.println("*************��ӭ����ͼ����Ϣ��ѯ�޸�ϵͳ:      "); 
//    	    		b.UpdateBooksInfo(); break;
//    	    	}break;
//    	    	//������Ϣ
//    		case 2:
//    			System.out.println("*************������Ϣ:      ");        
//    	    	System.out.println("   1. ��ѯ������Ϣ:      ");       
//    	    	System.out.println("   2. ���������Ϣ:      ");       
//    	    	System.out.println("   3. ɾ��������Ϣ:      ");       
//    	    	System.out.println("   4. �޸Ķ�����Ϣ:      ");         
//    	    	int p=input.nextInt();               
//    	    	switch(p)          
//    	    	{                  
//    	    	case 1:            
//    	    		System.out.println("*************��ӭ���������Ϣ��ѯϵͳ:      "); 
//    	    		System.out.println("   1. ��������ѯ������Ϣ:      ");    
//    	    		System.out.println("   2. ��id��ѯ������Ϣ:      "); 
//    	    		int b1=input.nextInt();	
//    	    		switch(b1)          
//        	    	{                  
//        	    	case 1:
//        	    		s.findallStudentInfo();break;
//        	    	case 2:
//        	    		b.findBooksid();break;
//    	    		}break;
//    	    	case 2:
//    	    		System.out.println("*************��ӭ���������Ϣ����ϵͳ:      "); 
//    	    		s.addStudentInfo();break;
//    	    	case 3:
//    	    		System.out.println("*************��ӭ���������Ϣɾ��ϵͳ:      "); 
//    	    		s.deleteStudentid();break;
//    	    	case 4:
//    	    		System.out.println("*************��ӭ���������Ϣ��ѯ�޸�ϵͳ:      "); 
//    	    		s.UndateStudentInfo(); break;
//    	    	}
//    			break;
//    	    	//����Ա��Ϣ
//    		case 3: 
//    			System.out.println("*************��ӭ�������Ա��ѯϵͳ:      ");  
//    			a.findallAdminiInfo();break;
//    			//����ͼ����Ϣ
//    		case 4:  
//    			System.out.println("       ����ͼ����Ϣ:      ");        
//    	    	System.out.println("   1. ��ѯ����ͼ����Ϣ:      ");       
//    	    	System.out.println("   2. �������ͼ����Ϣ:      ");       
//    	    	System.out.println("   3. ɾ������ͼ����Ϣ:      ");       
//    	    	System.out.println("   4. �޸Ľ���ͼ����Ϣ:      ");         
//    	    	int t1=input.nextInt();               
//    	    	switch(t1)          
//    	    	{                  
//    	    	case 1:            
//    	    		System.out.println("*************��ӭ�������ͼ����Ϣ��ѯϵͳ:      "); 
//    	    		System.out.println("   1. ��������ѯ����ͼ����Ϣ:      ");    
//    	    		System.out.println("   2. ��id��ѯ����ͼ����Ϣ:      "); 
//    	    		int b1=input.nextInt();	
//    	    		switch(b1)          
//        	    	{                  
//        	    	case 1:
//        	    	    bb.findallBorrowBookInfo(); break;
//        	    	case 2:
//        	    		bb.findaBorrowBookid();break;
//    	    		}break;
//    	    	case 2:
//    	    		System.out.println("*************��ӭ����������ͼ����Ϣ��ѯϵͳ:      "); 
//    	    		bb.addBorrowBooksInfo();break;
//    	    	case 3:
//    	    		System.out.println("*************��ӭ����ɾ������ͼ����Ϣ��ѯϵͳ:      "); 
//    	    		bb.deleteBorrowBooksid();break;
//    	    	case 4:
//    	    		System.out.println("*************��ӭ�����޸Ľ���ͼ����Ϣ��ѯϵͳ:      "); 
//    	    		bb.UndateorrowBooksInfo();break;
//    	    	}
//		
//	    	}
//	    	} 	
//		
//	}
//
//}