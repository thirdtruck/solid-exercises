package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategory
{
//  Name(76, "Name"),
//  MailingAddress(79, "MailingAddress"),
//  PhoneNumber(78, "PhoneNumber"),
//  EmailAddress(77, "EmailAddress"),
//  ContactInfo(80, "ContactInfo"),
//  CompanyName(81, "CompanyName"),
//  WorkExperience(82, "WorkExperience");

  @SuppressWarnings("unused")
  private int id;
  private String categoryName;

  public ConfidentialPhraseCategory(int id, String categoryName)
  {
    this.id = id;
    this.categoryName = categoryName;
  }
  
  public int id()
  {
    return this.id;
  }
  
  public String categoryName()
  {
    return this.categoryName;
  }
}
