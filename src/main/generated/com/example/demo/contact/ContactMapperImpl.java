package com.example.demo.contact;

import com.example.demo.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T09:55:28+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toEntity(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setUser( contactDtoToUser( contactDto ) );
        contact.setId( contactDto.getId() );
        contact.setFirstName( contactDto.getFirstName() );
        contact.setLastName( contactDto.getLastName() );
        contact.setCompanyName( contactDto.getCompanyName() );
        contact.setAddress( contactDto.getAddress() );

        return contact;
    }

    @Override
    public ContactDto toDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        Integer userId = null;
        String userUserName = null;
        String userPassword = null;
        Integer id = null;
        String firstName = null;
        String lastName = null;
        String companyName = null;
        String address = null;

        userId = contactUserId( contact );
        userUserName = contactUserUserName( contact );
        userPassword = contactUserPassword( contact );
        id = contact.getId();
        firstName = contact.getFirstName();
        lastName = contact.getLastName();
        companyName = contact.getCompanyName();
        address = contact.getAddress();

        ContactDto contactDto = new ContactDto( id, firstName, lastName, companyName, address, userId, userUserName, userPassword );

        return contactDto;
    }

    @Override
    public void updateContactFromContactDto(ContactDto contactDto, Contact contact) {
        if ( contactDto == null ) {
            return;
        }

        if ( contact.getUser() == null ) {
            contact.setUser( new User() );
        }
        contactDtoToUser1( contactDto, contact.getUser() );
        if ( contactDto.getId() != null ) {
            contact.setId( contactDto.getId() );
        }
        if ( contactDto.getFirstName() != null ) {
            contact.setFirstName( contactDto.getFirstName() );
        }
        if ( contactDto.getLastName() != null ) {
            contact.setLastName( contactDto.getLastName() );
        }
        if ( contactDto.getCompanyName() != null ) {
            contact.setCompanyName( contactDto.getCompanyName() );
        }
        if ( contactDto.getAddress() != null ) {
            contact.setAddress( contactDto.getAddress() );
        }
    }

    protected User contactDtoToUser(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( contactDto.getUserId() );
        user.setUserName( contactDto.getUserUserName() );
        user.setPassword( contactDto.getUserPassword() );

        return user;
    }

    private Integer contactUserId(Contact contact) {
        if ( contact == null ) {
            return null;
        }
        User user = contact.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String contactUserUserName(Contact contact) {
        if ( contact == null ) {
            return null;
        }
        User user = contact.getUser();
        if ( user == null ) {
            return null;
        }
        String userName = user.getUserName();
        if ( userName == null ) {
            return null;
        }
        return userName;
    }

    private String contactUserPassword(Contact contact) {
        if ( contact == null ) {
            return null;
        }
        User user = contact.getUser();
        if ( user == null ) {
            return null;
        }
        String password = user.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }

    protected void contactDtoToUser1(ContactDto contactDto, User mappingTarget) {
        if ( contactDto == null ) {
            return;
        }

        if ( contactDto.getUserId() != null ) {
            mappingTarget.setId( contactDto.getUserId() );
        }
        if ( contactDto.getUserUserName() != null ) {
            mappingTarget.setUserName( contactDto.getUserUserName() );
        }
        if ( contactDto.getUserPassword() != null ) {
            mappingTarget.setPassword( contactDto.getUserPassword() );
        }
    }
}
