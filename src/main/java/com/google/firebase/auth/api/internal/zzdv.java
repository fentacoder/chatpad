package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseAuthWebException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzu;
import com.google.firebase.auth.zzab;
import com.google.firebase.auth.zzs;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public final class zzdv {
  private static final SparseArray<Pair<String, String>> zza;
  
  static {
    SparseArray<Pair<String, String>> sparseArray = new SparseArray();
    zza = sparseArray;
    sparseArray.put(17000, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
    zza.put(17002, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
    zza.put(17004, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
    zza.put(17008, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
    zza.put(17009, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
    zza.put(17024, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
    zza.put(17014, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
    zza.put(17012, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
    zza.put(17007, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
    zza.put(17025, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
    zza.put(17005, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
    zza.put(17021, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
    zza.put(17011, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
    zza.put(17017, new Pair("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key."));
    zza.put(17006, new Pair("ERROR_OPERATION_NOT_ALLOWED", "The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase console, under the sign-in method tab of the Auth section."));
    zza.put(17026, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
    zza.put(17029, new Pair("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired."));
    zza.put(17030, new Pair("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used."));
    zza.put(17031, new Pair("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console."));
    zza.put(17033, new Pair("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid."));
    zza.put(17032, new Pair("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console."));
    zza.put(17034, new Pair("ERROR_MISSING_EMAIL", "An email address must be provided."));
    zza.put(17035, new Pair("ERROR_MISSING_PASSWORD", "A password must be provided."));
    zza.put(17041, new Pair("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient."));
    zza.put(17042, new Pair("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code]."));
    zza.put(17043, new Pair("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code"));
    zza.put(17044, new Pair("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user."));
    zza.put(17045, new Pair("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID"));
    zza.put(17046, new Pair("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid."));
    zza.put(17049, new Pair("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication."));
    zza.put(17051, new Pair("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again."));
    zza.put(17052, new Pair("ERROR_QUOTA_EXCEEDED", "The sms quota for this project has been exceeded."));
    zza.put(17028, new Pair("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verify that the correct package name and SHA-1 are configured in the Firebase Console."));
    zza.put(17063, new Pair("ERROR_API_NOT_AVAILABLE_WITHOUT_GOOGLE_PLAY", "The API that you are calling is not available on devices without Google Play services."));
    zza.put(17062, new Pair("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget."));
    zza.put(17064, new Pair("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash."));
    zza.put(17065, new Pair("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled."));
    zza.put(17040, new Pair("ERROR_MISSING_CONTINUE_URI", "A continue URL must be provided in the request."));
    zza.put(17068, new Pair("ERROR_DYNAMIC_LINK_NOT_ACTIVATED", "Please activate Dynamic Links in the Firebase Console and agree to the terms and conditions."));
    zza.put(17071, new Pair("ERROR_INVALID_PROVIDER_ID", "The provider ID provided for the attempted web operation is invalid."));
    zza.put(17057, new Pair("ERROR_WEB_CONTEXT_ALREADY_PRESENTED", "A headful operation is already in progress. Please wait for that to finish."));
    zza.put(17058, new Pair("ERROR_WEB_CONTEXT_CANCELED", "The web operation was canceled by the user."));
    zza.put(17072, new Pair("ERROR_TENANT_ID_MISMATCH", "The provided tenant ID does not match the Auth instance's tenant ID."));
    zza.put(17073, new Pair("ERROR_UNSUPPORTED_TENANT_OPERATION", "This operation is not supported in a multi-tenant context."));
    zza.put(17074, new Pair("ERROR_INVALID_DYNAMIC_LINK_DOMAIN", "The provided dynamic link domain is not configured or authorized for the current project."));
    zza.put(17075, new Pair("ERROR_REJECTED_CREDENTIAL", "The request contains malformed or mismatching credentials"));
    zza.put(17077, new Pair("ERROR_PHONE_NUMBER_NOT_FOUND", "The provided phone number does not match any of the second factor phone numbers associated with this user."));
    zza.put(17079, new Pair("ERROR_INVALID_TENANT_ID", "The Auth instance's tenant ID is invalid."));
    zza.put(17078, new Pair("ERROR_SECOND_FACTOR_REQUIRED", "Please complete a second factor challenge to finish signing into this account."));
    zza.put(17080, new Pair("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available."));
    zza.put(17081, new Pair("ERROR_MISSING_MULTI_FACTOR_SESSION", "The request is missing proof of first factor successful sign-in."));
    zza.put(17082, new Pair("ERROR_MISSING_MULTI_FACTOR_INFO", "No second factor identifier is provided."));
    zza.put(17083, new Pair("ERROR_INVALID_MULTI_FACTOR_SESSION", "The request does not contain a valid proof of first factor successful sign-in."));
    zza.put(17084, new Pair("ERROR_MULTI_FACTOR_INFO_NOT_FOUND", "The user does not have a second factor matching the identifier provided."));
    zza.put(17085, new Pair("ERROR_ADMIN_RESTRICTED_OPERATION", "This operation is restricted to administrators only."));
    zza.put(17086, new Pair("ERROR_UNVERIFIED_EMAIL", "This operation requires a verified email."));
    zza.put(17087, new Pair("ERROR_SECOND_FACTOR_ALREADY_ENROLLED", "The second factor is already enrolled on this account."));
    zza.put(17088, new Pair("ERROR_MAXIMUM_SECOND_FACTOR_COUNT_EXCEEDED", "The maximum allowed number of second factors on a user has been exceeded."));
    zza.put(17089, new Pair("ERROR_UNSUPPORTED_FIRST_FACTOR", "Enrolling a second factor or signing in with a multi-factor account requires sign-in with a supported first factor."));
    zza.put(17090, new Pair("ERROR_EMAIL_CHANGE_NEEDS_VERIFICATION", "Multi-factor users must always have a verified email."));
    zza.put(17091, new Pair("ERROR_INTERNAL_SUCCESS_SIGN_OUT", "This is an internal error code indicating that the operation was successful but the user needs to be signed out."));
    zza.put(17093, new Pair("ERROR_MISSING_CLIENT_IDENTIFIER", "This request is missing a reCAPTCHA token."));
    zza.put(17094, new Pair("ERROR_MISSING_OR_INVALID_NONCE", "The request does not contain a valid nonce. This can occur if the SHA-256 hash of the provided raw nonce does not match the hashed nonce in the ID token payload."));
    zza.put(18001, new Pair("ERROR_USER_CANCELLED", "The user did not grant your application the permissions it requested."));
  }
  
  public static FirebaseException zza(Status paramStatus) {
    int i = paramStatus.getStatusCode();
    String str = zza(zzb(i), paramStatus);
    if (i != 17020) {
      if (i != 17021)
        if (i != 17051) {
          if (i != 17052) {
            if (i != 17057 && i != 17058) {
              switch (i) {
                default:
                  switch (i) {
                    default:
                      switch (i) {
                        default:
                          switch (i) {
                            default:
                              switch (i) {
                                default:
                                  switch (i) {
                                    default:
                                      switch (i) {
                                        default:
                                          return new FirebaseException("An internal error has occurred.");
                                        case 17071:
                                        case 17072:
                                        case 17073:
                                        case 17074:
                                          return (FirebaseException)new FirebaseAuthException(zza(i), str);
                                        case 17075:
                                          break;
                                      } 
                                      break;
                                    case 17061:
                                      return (FirebaseException)new FirebaseNetworkException(zza("There was a failure in the connection between the web widget and the Firebase Auth backend.", paramStatus));
                                    case 17063:
                                      return (FirebaseException)new FirebaseApiNotAvailableException(str);
                                    case 17064:
                                    
                                    case 17062:
                                    case 17065:
                                      break;
                                  } 
                                  return (FirebaseException)new FirebaseAuthWebException(zza(i), str);
                                case 17040:
                                
                                case 17041:
                                case 17042:
                                case 17043:
                                case 17044:
                                case 17045:
                                case 17046:
                                  break;
                              } 
                              break;
                            case 17031:
                            case 17032:
                            case 17033:
                              return (FirebaseException)new FirebaseAuthEmailException(zza(i), str);
                            case 17029:
                            case 17030:
                              return (FirebaseException)new FirebaseAuthActionCodeException(zza(i), str);
                            case 17028:
                            
                            case 17034:
                            case 17035:
                              break;
                          } 
                          break;
                        case 17026:
                          return (FirebaseException)new FirebaseAuthWeakPasswordException(zza(i), str, paramStatus.getStatusMessage());
                        case 17025:
                          return (FirebaseException)new FirebaseAuthUserCollisionException(zza(i), str);
                        case 17024:
                          break;
                      } 
                    case 17016:
                      return new FirebaseException(zza("User was not linked to an account with the given provider.", paramStatus));
                    case 17015:
                      return new FirebaseException(zza("User has already been linked to the given provider.", paramStatus));
                    case 17014:
                      return (FirebaseException)new FirebaseAuthRecentLoginRequiredException(zza(i), str);
                    case 17017:
                      break;
                  } 
                  break;
                case 17499:
                  return new FirebaseException(zza("An internal error has occurred.", paramStatus));
                case 17495:
                  return (FirebaseException)new FirebaseNoSignedInUserException(zza("Please sign in before trying to get a token.", paramStatus));
                case 17080:
                
                case 17010:
                  return (FirebaseException)new FirebaseTooManyRequestsException(zza("We have blocked all requests from this device due to unusual activity. Try again later.", paramStatus));
                case 17007:
                case 17012:
                case 17006:
                case 17068:
                case 17079:
                case 17085:
                case 17086:
                case 17087:
                case 17088:
                case 17089:
                case 17090:
                case 17091:
                case 17093:
                case 18001:
                
                case 17000:
                case 17002:
                case 17004:
                case 17008:
                case 17009:
                case 17049:
                case 17077:
                case 17081:
                case 17082:
                case 17083:
                case 17084:
                case 17094:
                  return (FirebaseException)new FirebaseAuthInvalidCredentialsException(zza(i), str);
                case 17005:
                case 17011:
                  break;
              } 
            } else {
              return (FirebaseException)new FirebaseAuthWebException(zza(i), str);
            } 
          } else {
            return (FirebaseException)new FirebaseTooManyRequestsException(str);
          } 
          return (FirebaseException)new FirebaseAuthInvalidUserException(zza(i), str);
        }  
      return (FirebaseException)new FirebaseAuthInvalidUserException(zza(i), str);
    } 
    return (FirebaseException)new FirebaseNetworkException(zza("A network error (such as timeout, interrupted connection or unreachable host) has occurred.", paramStatus));
  }
  
  public static FirebaseAuthUserCollisionException zza(Status paramStatus, AuthCredential paramAuthCredential, String paramString1, String paramString2) {
    int i = paramStatus.getStatusCode();
    String str = zza(zzb(i), paramStatus);
    return (new FirebaseAuthUserCollisionException(zza(i), str)).zza(paramAuthCredential).zza(paramString1).zzb(paramString2);
  }
  
  public static zzs zza(FirebaseAuth paramFirebaseAuth, zzej paramzzej, FirebaseUser paramFirebaseUser) {
    zzav.zza(paramFirebaseAuth);
    zzav.zza(paramzzej);
    Pair pair = (Pair)zza.get(17078);
    return new zzs((String)pair.first, (String)pair.second, (zzab)zzu.zza(paramzzej, paramFirebaseAuth, paramFirebaseUser));
  }
  
  private static String zza(int paramInt) {
    Pair pair = (Pair)zza.get(paramInt);
    return (pair != null) ? (String)pair.first : "INTERNAL_ERROR";
  }
  
  private static String zza(String paramString, Status paramStatus) {
    return TextUtils.isEmpty(paramStatus.getStatusMessage()) ? paramString : String.format(String.valueOf(paramString).concat(" [ %s ]"), new Object[] { paramStatus.getStatusMessage() });
  }
  
  private static String zzb(int paramInt) {
    Pair pair = (Pair)zza.get(paramInt);
    return (pair != null) ? (String)pair.second : "An internal error has occurred.";
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzdv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */