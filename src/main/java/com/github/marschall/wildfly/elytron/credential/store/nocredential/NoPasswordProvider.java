package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import java.security.Provider;
import java.util.List;
import java.util.Map;

import org.wildfly.security.credential.store.CredentialStore;

/**
 * JCE Provider implementation that registers {@link NoCredentialStore}.
 */
public final class NoPasswordProvider extends Provider {

  public static final String ALGORITHM = "no-password";

  public static final String PROVIDER_NAME = "NoPasswordProvider";

  private static NoPasswordProvider INSTANCE = new NoPasswordProvider();

  /**
   * Default constructor called by JCE.
   */
  public NoPasswordProvider() {
    super(PROVIDER_NAME, "1.0", "no-password Password Provider");

    List<String> aliases = List.of();
    Map<String, String> attributes = Map.of();
    this.putService(new Service(this, CredentialStore.CREDENTIAL_STORE_TYPE, ALGORITHM, NoCredentialStore.class.getName(), aliases, attributes));
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
