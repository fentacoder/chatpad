package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.List;

public final class zzy {
  public static Status zza(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return new Status(17499); 
    String[] arrayOfString = paramString.split(":", 2);
    arrayOfString[0] = arrayOfString[0].trim();
    if (arrayOfString.length > 1 && arrayOfString[1] != null)
      arrayOfString[1] = arrayOfString[1].trim(); 
    List<String> list = Arrays.asList(arrayOfString);
    return (list.size() > 1) ? zza(list.get(0), list.get(1)) : zza(list.get(0), null);
  }
  
  private static Status zza(String paramString1, String paramString2) {
    short s;
    switch (paramString1.hashCode()) {
      default:
        s = -1;
        break;
      case 2082564316:
        if (paramString1.equals("UNSUPPORTED_TENANT_OPERATION")) {
          s = 49;
          break;
        } 
      case 2063209097:
        if (paramString1.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
          s = 63;
          break;
        } 
      case 1898790704:
        if (paramString1.equals("MISSING_SESSION_INFO")) {
          s = 35;
          break;
        } 
      case 1803454477:
        if (paramString1.equals("MISSING_CONTINUE_URI")) {
          s = 44;
          break;
        } 
      case 1497901284:
        if (paramString1.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
          s = 21;
          break;
        } 
      case 1494923453:
        if (paramString1.equals("INVALID_APP_CREDENTIAL")) {
          s = 19;
          break;
        } 
      case 1442968770:
        if (paramString1.equals("INVALID_PHONE_NUMBER")) {
          s = 32;
          break;
        } 
      case 1433767024:
        if (paramString1.equals("USER_DISABLED")) {
          s = 5;
          break;
        } 
      case 1388786705:
        if (paramString1.equals("INVALID_IDENTIFIER")) {
          s = 6;
          break;
        } 
      case 1226505451:
        if (paramString1.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
          s = 12;
          break;
        } 
      case 1199811910:
        if (paramString1.equals("MISSING_CODE")) {
          s = 33;
          break;
        } 
      case 1141576252:
        if (paramString1.equals("SESSION_EXPIRED")) {
          s = 38;
          break;
        } 
      case 1107081238:
        if (paramString1.equals("<<Network Error>>")) {
          s = 15;
          break;
        } 
      case 1094975491:
        if (paramString1.equals("INVALID_PASSWORD")) {
          s = 11;
          break;
        } 
      case 1072360691:
        if (paramString1.equals("INVALID_CUSTOM_TOKEN")) {
          s = 2;
          break;
        } 
      case 1034932393:
        if (paramString1.equals("INVALID_PENDING_TOKEN")) {
          s = 3;
          break;
        } 
      case 989000548:
        if (paramString1.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
          s = 22;
          break;
        } 
      case 922685102:
        if (paramString1.equals("INVALID_MESSAGE_PAYLOAD")) {
          s = 26;
          break;
        } 
      case 895302372:
        if (paramString1.equals("MISSING_CLIENT_IDENTIFIER")) {
          s = 65;
          break;
        } 
      case 886186878:
        if (paramString1.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
          s = 53;
          break;
        } 
      case 844240628:
        if (paramString1.equals("WEB_CONTEXT_CANCELED")) {
          s = 48;
          break;
        } 
      case 819646646:
        if (paramString1.equals("CREDENTIAL_MISMATCH")) {
          s = 1;
          break;
        } 
      case 799258561:
        if (paramString1.equals("INVALID_PROVIDER_ID")) {
          s = 46;
          break;
        } 
      case 786916712:
        if (paramString1.equals("INVALID_VERIFICATION_PROOF")) {
          s = 37;
          break;
        } 
      case 745638750:
        if (paramString1.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
          s = 56;
          break;
        } 
      case 605031096:
        if (paramString1.equals("REJECTED_CREDENTIAL")) {
          s = 52;
          break;
        } 
      case 582457886:
        if (paramString1.equals("UNVERIFIED_EMAIL")) {
          s = 59;
          break;
        } 
      case 542728406:
        if (paramString1.equals("PASSWORD_LOGIN_DISABLED")) {
          s = 18;
          break;
        } 
      case 492072102:
        if (paramString1.equals("WEB_STORAGE_UNSUPPORTED")) {
          s = 43;
          break;
        } 
      case 491979549:
        if (paramString1.equals("INVALID_ID_TOKEN")) {
          s = 13;
          break;
        } 
      case 483847807:
        if (paramString1.equals("EMAIL_EXISTS")) {
          s = 10;
          break;
        } 
      case 423563023:
        if (paramString1.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
          s = 54;
          break;
        } 
      case 408411681:
        if (paramString1.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
          s = 51;
          break;
        } 
      case 278802867:
        if (paramString1.equals("MISSING_PHONE_NUMBER")) {
          s = 31;
          break;
        } 
      case 269327773:
        if (paramString1.equals("INVALID_SENDER")) {
          s = 27;
          break;
        } 
      case 210308040:
        if (paramString1.equals("UNSUPPORTED_FIRST_FACTOR")) {
          s = 62;
          break;
        } 
      case 15352275:
        if (paramString1.equals("EMAIL_NOT_FOUND")) {
          s = 8;
          break;
        } 
      case -40686718:
        if (paramString1.equals("WEAK_PASSWORD")) {
          s = 16;
          break;
        } 
      case -75433118:
        if (paramString1.equals("USER_NOT_FOUND")) {
          s = 9;
          break;
        } 
      case -122667194:
        if (paramString1.equals("MISSING_MFA_ENROLLMENT_ID")) {
          s = 55;
          break;
        } 
      case -217128228:
        if (paramString1.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
          s = 61;
          break;
        } 
      case -294485423:
        if (paramString1.equals("WEB_INTERNAL_ERROR")) {
          s = 42;
          break;
        } 
      case -333672188:
        if (paramString1.equals("OPERATION_NOT_ALLOWED")) {
          s = 17;
          break;
        } 
      case -595928767:
        if (paramString1.equals("TIMEOUT")) {
          s = 14;
          break;
        } 
      case -646022241:
        if (paramString1.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
          s = 20;
          break;
        } 
      case -736207500:
        if (paramString1.equals("MISSING_PASSWORD")) {
          s = 30;
          break;
        } 
      case -749743758:
        if (paramString1.equals("MFA_ENROLLMENT_NOT_FOUND")) {
          s = 57;
          break;
        } 
      case -828507413:
        if (paramString1.equals("NO_SUCH_PROVIDER")) {
          s = 0;
          break;
        } 
      case -863830559:
        if (paramString1.equals("INVALID_CERT_HASH")) {
          s = 40;
          break;
        } 
      case -974503964:
        if (paramString1.equals("MISSING_OR_INVALID_NONCE")) {
          s = 66;
          break;
        } 
      case -1063710844:
        if (paramString1.equals("ADMIN_ONLY_OPERATION")) {
          s = 58;
          break;
        } 
      case -1112393964:
        if (paramString1.equals("INVALID_EMAIL")) {
          s = 7;
          break;
        } 
      case -1202691903:
        if (paramString1.equals("SECOND_FACTOR_EXISTS")) {
          s = 60;
          break;
        } 
      case -1232010689:
        if (paramString1.equals("INVALID_SESSION_INFO")) {
          s = 36;
          break;
        } 
      case -1340100504:
        if (paramString1.equals("INVALID_TENANT_ID")) {
          s = 50;
          break;
        } 
      case -1345867105:
        if (paramString1.equals("TOKEN_EXPIRED")) {
          s = 23;
          break;
        } 
      case -1421414571:
        if (paramString1.equals("INVALID_CODE")) {
          s = 34;
          break;
        } 
      case -1458751677:
        if (paramString1.equals("MISSING_EMAIL")) {
          s = 29;
          break;
        } 
      case -1583894766:
        if (paramString1.equals("INVALID_OOB_CODE")) {
          s = 24;
          break;
        } 
      case -1587614300:
        if (paramString1.equals("EXPIRED_OOB_CODE")) {
          s = 25;
          break;
        } 
      case -1774756919:
        if (paramString1.equals("WEB_NETWORK_REQUEST_FAILED")) {
          s = 41;
          break;
        } 
      case -1800638118:
        if (paramString1.equals("QUOTA_EXCEEDED")) {
          s = 39;
          break;
        } 
      case -1944433728:
        if (paramString1.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
          s = 45;
          break;
        } 
      case -2001169389:
        if (paramString1.equals("INVALID_IDP_RESPONSE")) {
          s = 4;
          break;
        } 
      case -2005236790:
        if (paramString1.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
          s = 64;
          break;
        } 
      case -2014808264:
        if (paramString1.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
          s = 47;
          break;
        } 
      case -2065866930:
        if (paramString1.equals("INVALID_RECIPIENT_EMAIL")) {
          s = 28;
          break;
        } 
      case -2130504259:
        if (paramString1.equals("USER_CANCELLED")) {
          s = 67;
          break;
        } 
    } 
    switch (s) {
      default:
        s = 17499;
        break;
      case 67:
        s = 18001;
        break;
      case 66:
        s = 17094;
        break;
      case 65:
        s = 17093;
        break;
      case 64:
        s = 17091;
        break;
      case 63:
        s = 17090;
        break;
      case 62:
        s = 17089;
        break;
      case 61:
        s = 17088;
        break;
      case 60:
        s = 17087;
        break;
      case 59:
        s = 17086;
        break;
      case 58:
        s = 17085;
        break;
      case 57:
        s = 17084;
        break;
      case 56:
        s = 17083;
        break;
      case 55:
        s = 17082;
        break;
      case 54:
        s = 17081;
        break;
      case 53:
        s = 17078;
        break;
      case 52:
        s = 17075;
        break;
      case 51:
        s = 17074;
        break;
      case 50:
        s = 17079;
        break;
      case 49:
        s = 17073;
        break;
      case 48:
        s = 17058;
        break;
      case 47:
        s = 17057;
        break;
      case 46:
        s = 17071;
        break;
      case 45:
        s = 17068;
        break;
      case 44:
        s = 17040;
        break;
      case 43:
        s = 17065;
        break;
      case 42:
        s = 17062;
        break;
      case 41:
        s = 17061;
        break;
      case 40:
        s = 17064;
        break;
      case 39:
        s = 17052;
        break;
      case 38:
        s = 17051;
        break;
      case 37:
        s = 17049;
        break;
      case 36:
        s = 17046;
        break;
      case 35:
        s = 17045;
        break;
      case 34:
        s = 17044;
        break;
      case 33:
        s = 17043;
        break;
      case 32:
        s = 17042;
        break;
      case 31:
        s = 17041;
        break;
      case 30:
        s = 17035;
        break;
      case 29:
        s = 17034;
        break;
      case 28:
        s = 17033;
        break;
      case 27:
        s = 17032;
        break;
      case 26:
        s = 17031;
        break;
      case 25:
        s = 17029;
        break;
      case 24:
        s = 17030;
        break;
      case 23:
        s = 17021;
        break;
      case 21:
      case 22:
        s = 17010;
        break;
      case 20:
        s = 17014;
        break;
      case 19:
        s = 17028;
        break;
      case 17:
      case 18:
        s = 17006;
        break;
      case 16:
        s = 17026;
        break;
      case 14:
      case 15:
        s = 17020;
        break;
      case 13:
        s = 17017;
        break;
      case 12:
        s = 17025;
        break;
      case 11:
        s = 17009;
        break;
      case 10:
        s = 17007;
        break;
      case 8:
      case 9:
        s = 17011;
        break;
      case 6:
      case 7:
        s = 17008;
        break;
      case 5:
        s = 17005;
        break;
      case 3:
      case 4:
        s = 17004;
        break;
      case 2:
        s = 17000;
        break;
      case 1:
        s = 17002;
        break;
      case 0:
        s = 17016;
        break;
    } 
    if (s == 17499) {
      if (paramString2 != null) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length());
        stringBuilder.append(paramString1);
        stringBuilder.append(":");
        stringBuilder.append(paramString2);
        return new Status(s, stringBuilder.toString());
      } 
      return new Status(s, paramString1);
    } 
    return new Status(s, paramString2);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */