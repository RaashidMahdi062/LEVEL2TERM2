/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;



/**
 *
 * @author User
 */



public enum all_district {
Barguna,
Barisal,
Bhola,
Jhalokati,
Patuakhali,
Pirojpur,
Bandarban,
Brahmanbaria,
Chandpur,
Chittagong,
Comilla,
CoxsBazar,
Feni,
Khagrachhari,
Lakshmipur,
Noakhali,
Rangamati,
Dhaka,
Faridpur,
Gazipur,
Gopalganj,
Jamalpur,
Kishoreganj,
Madaripur,
Manikganj,
Munshiganj,
Mymensingh,
Narayanganj,
Narsingdi,
Netrakona,
Rajbari,
Shariatpur,
Sherpur,
Tangail,
Bagerhat, 
Chuadanga,
Jessore,
Jhenaidah,
Khulna,
Kushtia,
Magura,
Meherpur,
Narail,
Satkhira,
Bogra,
Joypurhat,
Naogaon,
Natore,
Nawabganj,
Pabna,
Rajshahi,
Sirajganj,
Dinajpur,
Gaibandha,
Kurigram,
Lalmonirhat,
Nilphamari,
Panchagarh,
Rangpur,
Thakurgaon,
Habiganj,
Moulvibazar,
Sunamganj,
Sylhet;

    all_district(){};


    public String value()
    {
        return name();
    }

    public static all_district fromvalue(String v)
    {
        return valueOf(v);
    }
}
