package RestApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.api.crud.entity.Employeedetails;

public class ClientAPI {

	
	private static final String Get_Allemployees_URL="http://localhost:8080/api/company_details";
	private static final String get_employee_ByID_URL="http://localhost:8080/api/company_details/{id}";

	
	private String url="jdbc:mysql://localhost:3306/getinfo";
	private String username="root";
	private String password="";
	
    private static RestTemplate rt=new RestTemplate();
	
	public void getallemployee() {
		
    try {
			
    	Connection con=DriverManager.getConnection(url, username, password);
			
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String>entity=new HttpEntity<String>("parameters",headers);
			
			                      //entity class name 
			ResponseEntity<List<Employeedetails>>result=rt.exchange(Get_Allemployees_URL, HttpMethod.GET, entity, 
					new ParameterizedTypeReference<List<Employeedetails>>(){});
			List<Employeedetails>empdata=result.getBody();
			
             for (Employeedetails empdet : empdata) {
				
				long id=empdet.getId();
				String emp_name=empdet.getName();
				String emp_address=empdet.getAddress();
				String emp_salary=empdet.getSalary();
				String emp_age=empdet.getAge();
				

				System.out.println(id+" "+emp_name+" "+emp_address+" "+emp_salary+" "+emp_age);
				
				Statement stmt=con.createStatement();
				String query="insert into emp_details value("+id+",'"+emp_name+"','"+emp_address+"','"+emp_salary+"','"+emp_age+"'"+")";
				stmt.executeUpdate(query);
				
			}
    } catch (Exception e) {
		System.out.println(e);
	} 
   
	
}
	 private static void getempbyID() {
	    	
		 Map<String, String> p=new HashMap<String,String>();
			p.put("id", "5");
			
			Employeedetails emdet=rt.getForObject(get_employee_ByID_URL, Employeedetails.class, p);
			

			long id=emdet.getId();
			String emp_name=emdet.getName();
			String emp_address=emdet.getAddress();
			String emp_salary=emdet.getSalary();
			String emp_age=emdet.getAge();
			
			System.out.println(id+" "+emp_name+" "+emp_address+" "+emp_salary+" "+emp_age);
			

		 
	    }
	 
	public static void main(String[] args) {
		
		ClientAPI ca=new ClientAPI();
		ca.getallemployee();
		
		getempbyID();
		
	}
	
		
	}
	
	
	

