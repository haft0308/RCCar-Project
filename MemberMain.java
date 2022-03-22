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
		System.out.println("======멤버관리프로그램==========");
		String menuStr = "1.추가 2.검색 3.수정 4.삭제 5. 전체출력 6.데이터초기화 7.종료";
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
				System.out.print("추가할");
				inputMember(data);
				
				break;
			case 2://탐색
				idx = search(data);
				if ( idx<0)
				{
					System.out.println("찾은 결과가 없습니다.");
				}
				break;
			case 3:
				//수정
				result = printAllMembers(data);
				if (result==EMPTY)
				{
					System.out.println("멤버가 없습니다");
					continue;
				}
				System.out.println("수정할 인덱스를 입력하시오");
				idx = sc.nextInt();
				Member mTemp = data.get(idx-1);
				System.out.print("수정할 이름 :");
				mTemp.setName(sc.next());
				System.out.print("수정할 전화번호 :");
				mTemp.setTel(sc.next());
				sc.nextLine();
				System.out.print("수정할 주소:");
				mTemp.setAddress(sc.nextLine());
				//data.set(idx-1, )
				printAllMembers(data);
				
				break;
			case 4:
				//삭제기능		
				//deleteMember(data);
				result = printAllMembers(data);
				if ( result == EMPTY)
				{
					continue;//데이터가 없어서 삭제할 수 없음.
				}
				System.out.println("삭제하고자 하는 멤버의 index를 입력하시오");
				
				//전체리스트 보여주기.(인덱스 포함한 전체리스트)
				//삭제할 인덱스 선택하기
				idx = sc.nextInt();
				//delete(삭제할 인덱스)
				
				data.remove(idx-1);
				System.out.println("삭제되었습니다.");
				//
				break;
			case 5:
				//전체 출력
				printAllMembers(data);
//				for (int i = 0;i <data.size(); i++)
//				{
//					Member mem = data.get(i);
//					System.out.println(i +". "+mem.toString());
//				}
				break;
			case 6:
				//데이터 초기화.
				data.removeAll(data);
				System.out.println("데이터 초기화 완료.");
				break;
			case 7:
				flag = false; 
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
				
			}
			
		}//while
	}
	
	int search(ArrayList<Member> data)
	{
		//boolean isMatch=false;
		int idx = -1;
		System.out.println("검색할 이름을 입력해주세요");
		String srh = sc.next();				
		
		
		for ( int i = 0;i <data.size(); i++)
		{
			Member m = data.get(i);
			System.out.println("["+srh+"]로 검색한 결과는 다음과 같습니다.");
			if( m.getName().equals(srh)) {
				System.out.println(i+". "+m.toString());
				//isMatch=true;
				idx = i;
				break;//한번 찾으면 멈추자.
			}
		}
//		if ( isMatch==false)
//		{
//			System.out.println("찾은 결과가 없습니다.");
//		}
		return idx;
	}
	
	int EMPTY = -1;
	int SUCCESS = 0;
	public Member input()
	{
		System.out.println(" 멤버의 정보를 입력하세요.");
		System.out.print("이름:");
		String name = sc.next();
		System.out.print("전화번호:");
		String tel  = sc.next();
		sc.nextLine();
		System.out.print("주소:");
		String address = sc.nextLine();
		Member m = new Member(name, tel, address);
		return m;
	}
	public void inputMember(ArrayList<Member> data)
	{
		Member m = input();
		data.add(m);
		
		System.out.println("멤버가 추가되었습니다.");
		//Member m2 = data.get(0);
		//System.out.println(m2.toString());
	}
	int printAllMembers(ArrayList<Member> data)
	{
		if ( data.size() <= 0 )
		{
			System.out.println("멤버가 없습니다.");
			return EMPTY;
		}
		System.out.println("<멤버리스트>--------------------------------------------------------");
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