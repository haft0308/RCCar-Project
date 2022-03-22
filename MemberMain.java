package Member;

import java.util.ArrayList;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyDB db = new MyDB();
//		db.connect();
		
		
		
		ArrayList<Member> al = new ArrayList<Member>();
		MemberMenu mm = new MemberMenu();
		mm.menuProcess(al);
		
	}

}

class Member
{
//	private int no;
	private String name;
	private String tel;
	private String address;
	
//	public int getNo() {
//		return no;
//	}
//	public void setNo(int no) {
//		this.no = no;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		
		this.address = address;
	}
//	Member(int no, String name, String tel, String address) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.tel = tel;
//		this.address = address;
//	}
	
	Member( String name, String tel, String address) {
		super();		
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	Member()
	{
		
	}
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "Member [no. "+no+", name=" + name + 
//				",tel=" +tel+
//				",address="+address+"]";
//	}
	public String toString() {
		// TODO Auto-generated method stub
		return "Member [ name=" + name + 
				",tel=" +tel+
				",address="+address+"]";
	}
	
	
}

class MemberMenu {
	boolean flag = true;
	java.util.Scanner sc = new java.util.Scanner(System.in);
	public void menuProcess(ArrayList<Member> data)
	{
		System.out.println("======����������α׷�==========");
		String menuStr = "1.�߰� 2.�˻� 3.���� 4.���� 5. ��ü��� 6.�������ʱ�ȭ 7.����";
		int menu = 0;
		int result=0;
		int idx=0;
		while ( flag )
		{
			System.out.println(menuStr);
			menu = sc.nextInt();
			switch(menu)
			{
			case 1:
				System.out.print("�߰���");
				inputMember(data);
				
				break;
			case 2://Ž��
				idx = search(data);
				if ( idx<0)
				{
					System.out.println("ã�� ����� �����ϴ�.");
				}
				break;
			case 3:
				//����
				result = printAllMembers(data);
				if (result==EMPTY)
				{
					System.out.println("����� �����ϴ�");
					continue;
				}
				System.out.println("������ �ε����� �Է��Ͻÿ�");
				idx = sc.nextInt();
				Member mTemp = data.get(idx-1);
				System.out.print("������ �̸� :");
				mTemp.setName(sc.next());
				System.out.print("������ ��ȭ��ȣ :");
				mTemp.setTel(sc.next());
				sc.nextLine();
				System.out.print("������ �ּ�:");
				mTemp.setAddress(sc.nextLine());
				//data.set(idx-1, )
				printAllMembers(data);
				
				break;
			case 4:
				//�������		
				//deleteMember(data);
				result = printAllMembers(data);
				if ( result == EMPTY)
				{
					continue;//�����Ͱ� ��� ������ �� ����.
				}
				System.out.println("�����ϰ��� �ϴ� ����� index�� �Է��Ͻÿ�");
				
				//��ü����Ʈ �����ֱ�.(�ε��� ������ ��ü����Ʈ)
				//������ �ε��� �����ϱ�
				idx = sc.nextInt();
				//delete(������ �ε���)
				
				data.remove(idx-1);
				System.out.println("�����Ǿ����ϴ�.");
				//
				break;
			case 5:
				//��ü ���
				printAllMembers(data);
//				for (int i = 0;i <data.size(); i++)
//				{
//					Member mem = data.get(i);
//					System.out.println(i +". "+mem.toString());
//				}
				break;
			case 6:
				//������ �ʱ�ȭ.
				data.removeAll(data);
				System.out.println("������ �ʱ�ȭ �Ϸ�.");
				break;
			case 7:
				flag = false; 
				System.out.println("����Ǿ����ϴ�.");
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
				
			}
			
		}//while
	}
	
	int search(ArrayList<Member> data)
	{
		//boolean isMatch=false;
		int idx = -1;
		System.out.println("�˻��� �̸��� �Է����ּ���");
		String srh = sc.next();				
		
		
		for ( int i = 0;i <data.size(); i++)
		{
			Member m = data.get(i);
			System.out.println("["+srh+"]�� �˻��� ����� ������ �����ϴ�.");
			if( m.getName().equals(srh)) {
				System.out.println(i+". "+m.toString());
				//isMatch=true;
				idx = i;
				break;//�ѹ� ã���� ������.
			}
		}
//		if ( isMatch==false)
//		{
//			System.out.println("ã�� ����� �����ϴ�.");
//		}
		return idx;
	}
	
	int EMPTY = -1;
	int SUCCESS = 0;
	public Member input()
	{
		System.out.println(" ����� ������ �Է��ϼ���.");
		System.out.print("�̸�:");
		String name = sc.next();
		System.out.print("��ȭ��ȣ:");
		String tel  = sc.next();
		sc.nextLine();
		System.out.print("�ּ�:");
		String address = sc.nextLine();
		Member m = new Member(name, tel, address);
		return m;
	}
	public void inputMember(ArrayList<Member> data)
	{
		Member m = input();
		data.add(m);
		
		System.out.println("����� �߰��Ǿ����ϴ�.");
		//Member m2 = data.get(0);
		//System.out.println(m2.toString());
	}
	int printAllMembers(ArrayList<Member> data)
	{
		if ( data.size() <= 0 )
		{
			System.out.println("����� �����ϴ�.");
			return EMPTY;
		}
		System.out.println("<�������Ʈ>--------------------------------------------------------");
		java.util.Iterator<Member> iter = data.iterator();
		int cnt=0;
		while(iter.hasNext())
		{
			Member mem = iter.next();
			cnt++;
			System.out.println((cnt) +". "+mem.toString());
		}
		
		System.out.println("-----------------------------------------------------------------");
		return SUCCESS;
		
	}

}