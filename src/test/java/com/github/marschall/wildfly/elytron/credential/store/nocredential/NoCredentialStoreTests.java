package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.security.GeneralSecurityException;

import org.junit.jupiter.api.Test;
import org.wildfly.security.credential.PasswordCredential;
import org.wildfly.security.credential.store.CredentialStore;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.interfaces.ClearPassword;

class NoCredentialStoreTests {

  @Test
  void getPassword() throws GeneralSecurityException {
    CredentialStore credentialStore = CredentialStore.getInstance(NoPasswordProvider.PROVIDER_NAME);
    Password password = credentialStore.retrieve("alias", PasswordCredential.class).getPassword();
    ClearPassword clearPassword = password.castAs(ClearPassword.class);
    assertNull(clearPassword.getPassword());
  }

}
