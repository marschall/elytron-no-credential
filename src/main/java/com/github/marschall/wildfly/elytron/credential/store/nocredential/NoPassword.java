package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import org.wildfly.security.password.Password;
import org.wildfly.security.password.interfaces.ClearPassword;

final class NoPassword implements ClearPassword {
  
  static Password INSTANCE = new NoPassword();

  private NoPassword() {
    super();
  }

  @Override
  public String getAlgorithm() {
    return ALGORITHM_CLEAR;
  }

  @Override
  public String getFormat() {
    return null;
  }

  @Override
  public byte[] getEncoded() {
    return null;
  }

  @Override
  public char[] getPassword() throws IllegalStateException {
    return null;
  }

  @Override
  public ClearPassword clone() {
    return this;
  }

}
