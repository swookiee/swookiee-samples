#API Document


## BasePath: /services

## Api Version: 1.0.0-SNAPSHOT

## Resources
### 0. /FizzBuzz!!
#### Overview


#### 0. `/4/fizzbuzz/{limit}`
##### 0..0 fizzbuzz
**GET** `/4/fizzbuzz/{limit}`

FizzBuzz Calculus


###### URL
    /services/4/fizzbuzz/{limit}
###### Parameters
- path

    <table border="1">
        <tr>
            <th>Parameter</th>
            <th>Required</th>
            <th>Description</th>
            <th>Data Type</th>
        </tr>
        <tr>
            <th>limit</th>
            <td>true</td>
            <td></td>
            <td>int</td>
        </tr>
    </table>

###### Response
[List[string]](#)


###### Errors
<table border="1">
    <tr>
        <th>Status Code</th>
        <th>Reason</th>
    </tr>
        <tr>
            <td>400</td>
            <td>If the limit input is greater than 10000</td>
        </tr>
</table>


- - -

## Data Types
