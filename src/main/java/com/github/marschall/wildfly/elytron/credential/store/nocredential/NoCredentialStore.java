package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Map;

import org.wildfly.security.credential.Credential;
import org.wildfly.security.credential.PasswordCredential;
import org.wildfly.security.credential.store.CredentialStore.ProtectionParameter;
import org.wildfly.security.credential.store.CredentialStoreException;
import org.wildfly.security.credential.store.CredentialStoreSpi;
import org.wildfly.security.credential.store.UnsupportedCredentialTypeException;

public final class NoCredentialStore extends CredentialStoreSpi {

  public NoCredentialStore() {
    super();
  }

  @Override
  public void initialize(Map<String, String> attributes, ProtectionParameter protectionParameter, Provider[] providers) {
    this.initialized = true;
  }

  @Override
  public boolean isModifiable() {
    return false;
  }

  @Override
  public void store(String credentialAlias, Credential credential, ProtectionParameter protectionParameter) throws CredentialStoreException {
    throw new CredentialStoreException("non modifiable credential store");
  }

  @Override
  public <C extends Credential> C retrieve(String credentialAlias, Class<C> credentialType, String credentialAlgorithm,
      AlgorithmParameterSpec parameterSpec, ProtectionParameter protectionParameter) throws CredentialStoreException {
    this.assertInitialized();
    if (credentialType.isAssignableFrom(PasswordCredential.class)) {
      return new PasswordCredential(NoPassword.INSTANCE).castAs(credentialType);
    }
    throw new UnsupportedCredentialTypeException("Unsupported credential type: " + credentialType);
  }

  private void assertInitialized() throws CredentialStoreException {
    if (!this.initialized) {
      throw new CredentialStoreException("not initialized");
    }
  }

  @Override
  public void remove(String credentialAlias, Class<? extends Credential> credentialType, String credentialAlgorithm, AlgorithmParameterSpec parameterSpec)
      throws CredentialStoreException {
    throw new CredentialStoreException("non modifiable credential store");
  }

  @Override
  public boolean exists(String credentialAlias, Class<? extends Credential> credentialType) {
    return credentialType.isAssignableFrom(PasswordCredential.class);
  }

}
