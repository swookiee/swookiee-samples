#Swookiee Swagger Demo


##  | :///services






**Version** 1.0.0-SNAPSHOT

[**Terms of Service**]()












# APIs


## /3/fizzbuzz/{limit}


### GET

<a id="fizzbuzz">FizzBuzz Calculus</a>









#### Request



##### Parameters

<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <th>limit</th>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td> - </td>

    
            <td>integer (int32)</td>
    

</tr>


</table>



#### Response

**Content-Type: ** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href=""></a>]|
| 400    | If the limit input is greater than 10000 |  - |



















# Definitions


