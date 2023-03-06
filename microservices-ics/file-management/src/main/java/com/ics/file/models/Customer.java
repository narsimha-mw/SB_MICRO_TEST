package com.ics.file.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

private String CustomerID;
private String CompanyName;
private String ContactName;
private String ContactTitle;
private String phone;

}
