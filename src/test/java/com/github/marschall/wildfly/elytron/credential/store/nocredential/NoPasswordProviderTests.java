package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.Provider;
import java.security.Security;

import org.junit.jupiter.api.Test;

class NoPasswordProviderTests {

  @Test
  void providerInstallation() {
    Provider[] providers = Security.getProviders();
    assertNotNull(providers);
    Provider provider = providers[providers.length - 1];
    assertTrue(provider instanceof NoPasswordProvider);
  }

}
