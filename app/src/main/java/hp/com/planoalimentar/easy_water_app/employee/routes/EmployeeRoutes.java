package hp.com.planoalimentar.easy_water_app.employee.routes;

import hp.com.planoalimentar.easy_water_app.api.statics.ApiRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 27/10/2020.
 */
public class EmployeeRoutes {

    /**
     * Get the url to get the
     * Employee Information
     * @param employeeCode
     * @return url
     * */
    public static String getEmployeeInformation(String employeeCode){
        if(employeeCode == null)
            throw new NullPointerException("Employee code can't be null");
        return ApiRoutes.EMPLOYEE.path()+employeeCode;
    }


}
