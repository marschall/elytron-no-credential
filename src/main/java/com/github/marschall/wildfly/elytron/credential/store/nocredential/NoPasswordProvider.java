package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import java.security.Provider;
import java.util.List;
import java.util.Map;

import org.wildfly.security.credential.store.CredentialStore;

public final class NoPasswordProvider extends Provider {

  public static final String PROVIDER_NAME = "NoPasswordProvider";

  private static NoPasswordProvider INSTANCE = new NoPasswordProvider();

  /**
   * Default constructor called by JCE.
   */
  public NoPasswordProvider() {
    super(PROVIDER_NAME, "1.0", "no-password Password Provider");
    putService(new Service(this, CredentialStore.CREDENTIAL_STORE_TYPE, "no-password", NoPasswordProvider.class.getName(), List.of(), Map.of()));
  }

  /**
   * Get the password implementations provider instance.
   *
   * @return the password implementations provider instance
   */
  public static NoPasswordProvider getInstance() {
    return INSTANCE;
  }

}
