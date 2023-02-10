package com.github.marschall.wildfly.elytron.credential.store.nocredential;

import org.wildfly.security.password.Password;
import org.wildfly.security.password.interfaces.ClearPassword;

/**
 * An implementation {@link ClearPassword} for a {@code null} password.
 * 
 * Similar to RawClearPassword.
 */
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
  public char[] getPassword() {
    return null;
  }

  @Override
  public ClearPassword clone() {
    return this;
  }

}
