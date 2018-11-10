package io.github.fentonmartin.aappz.util;

public class GoogleAdsZ {

    /* HERE: GoogleAdsZ -------------------------------------------------------------------------------
     *  Google Banner
     *  => Set Google Ads Banner with unitId and layout id
     *  Google Interstitial
     *  => Set Google Ads Interstitial with unitId and show function
     *  Google Video
     *  => Set Google Ads Video with unitId and show function
     *  */

//    private InterstitialAd mInterstitialAd;
//    private RewardedVideoAd mRewardedVideoAd;
//
//    public void adsGoogleBanner(String unitId, int id) {
//        setLog("GoogleAdsZ | adsGoogleBanner: onInitial");
//        MobileAds.initialize(this, unitId);
//
//        AdView mAdView = findViewById(id);
//        if (mAdView != null) {
//            setLog("GoogleAdsZ | adsGoogleBanner: onRequest");
//            mAdView.loadAd(new AdRequest.Builder().build());
//            mAdView.setAdListener(new AdListener() {
//                @Override
//                public void onAdLoaded() {
//                    setLog("GoogleAdsZ | adsGoogleBanner: onAdLoaded");
//                }
//
//                @Override
//                public void onAdFailedToLoad(int errorCode) {
//                    setLog("GoogleAdsZ | adsGoogleBanner: onAdFailedToLoad " + errorCode);
//                }
//
//                @Override
//                public void onAdOpened() {
//                    setLog("GoogleAdsZ | adsGoogleBanner: onAdOpened");
//                }
//
//                @Override
//                public void onAdLeftApplication() {
//                    setLog("GoogleAdsZ | adsGoogleBanner: onAdLeftApplication");
//                }
//
//                @Override
//                public void onAdClosed() {
//                    setLog("GoogleAdsZ | adsGoogleBanner: onAdClosed");
//                }
//            });
//        }
//    }
//
//    public void adsGoogleBanner(String unitId, int id, AdListener listener) {
//        setLog("GoogleAdsZ | adsGoogleBanner: onInitial");
//        MobileAds.initialize(this, unitId);
//
//        AdView mAdView = findViewById(id);
//        if (mAdView != null) {
//            setLog("GoogleAdsZ | adsGoogleBanner: onRequest");
//            mAdView.loadAd(new AdRequest.Builder().build());
//            mAdView.setAdListener(listener);
//        }
//    }
//
//    public void adsGoogleInterstitial(final String unitId) {
//        setLog("GoogleAdsZ | adsGoogleInterstitial: onInitial");
//        mInterstitialAd = new InterstitialAd(getApplicationContext());
//        mInterstitialAd.setAdUnitId(unitId);
//        if (mInterstitialAd != null) {
//            mInterstitialAd.loadAd(new AdRequest.Builder().build());
//            mInterstitialAd.setAdListener(new AdListener() {
//                @Override
//                public void onAdLoaded() {
//                    setLog("GoogleAdsZ | adsGoogleInterstitial: onAdLoaded");
//                }
//
//                @Override
//                public void onAdFailedToLoad(int errorCode) {
//                    setLog("GoogleAdsZ | adsGoogleInterstitial: onAdFailedToLoad " + errorCode);
//                    adsGoogleInterstitial(unitId);
//                }
//
//                @Override
//                public void onAdOpened() {
//                    setLog("GoogleAdsZ | adsGoogleInterstitial: onAdOpened");
//                    adsGoogleInterstitial(unitId);
//                }
//
//                @Override
//                public void onAdLeftApplication() {
//                    setLog("GoogleAdsZ | adsGoogleInterstitial: onAdLeftApplication");
//                    adsGoogleInterstitial(unitId);
//                }
//
//                @Override
//                public void onAdClosed() {
//                    setLog("GoogleAdsZ | adsGoogleInterstitial: onAdClosed");
//                    adsGoogleInterstitial(unitId);
//                }
//            });
//        }
//    }
//
//    public void adsGoogleInterstitial(String unitId, AdListener listener) {
//        setLog("GoogleAdsZ | adsGoogleInterstitial: onInitial");
//        mInterstitialAd = new InterstitialAd(getApplicationContext());
//        mInterstitialAd.setAdUnitId(unitId);
//        if (mInterstitialAd != null) {
//            mInterstitialAd.loadAd(new AdRequest.Builder().build());
//            mInterstitialAd.setAdListener(listener);
//        }
//    }
//
//    public void adsGoogleInterstitialShow() {
//        setLog("GoogleAdsZ | adsGoogleInterstitialShow: onInitial");
//        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
//            setLog("GoogleAdsZ | adsGoogleInterstitialShow: isLoaded");
//            mInterstitialAd.show();
//        } else {
//            setLog("GoogleAdsZ | adsGoogleInterstitialShow: FAILED");
//        }
//    }
//
//    public void adsGoogleVideo(final String unitId) {
//        setLog("GoogleAdsZ | adsGoogleVideo: onInitial");
//        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getApplicationContext());
//        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
//            @Override
//            public void onRewardedVideoAdLoaded() {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoAdLoaded");
//            }
//
//            @Override
//            public void onRewardedVideoAdOpened() {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoAdOpened");
//            }
//
//            @Override
//            public void onRewardedVideoStarted() {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoStarted");
//            }
//
//            @Override
//            public void onRewardedVideoAdClosed() {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoAdClosed");
//                adsGoogleVideoLoad(unitId);
//            }
//
//            @Override
//            public void onRewarded(RewardItem rewardItem) {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewarded");
//                adsGoogleVideoLoad(unitId);
//            }
//
//            @Override
//            public void onRewardedVideoAdLeftApplication() {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoAdLeftApplication");
//                adsGoogleVideoLoad(unitId);
//            }
//
//            @Override
//            public void onRewardedVideoAdFailedToLoad(int i) {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoAdFailedToLoad");
//                adsGoogleVideoLoad(unitId);
//            }
//
//            @Override
//            public void onRewardedVideoCompleted() {
//                setLog("GoogleAdsZ | adsGoogleVideo: onRewardedVideoCompleted");
//                adsGoogleVideoLoad(unitId);
//            }
//        });
//        adsGoogleVideoLoad(unitId);
//    }
//
//    public void adsGoogleVideo(String unitId, RewardedVideoAdListener listener) {
//        setLog("GoogleAdsZ | adsGoogleVideo: onInitial");
//        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getApplicationContext());
//        mRewardedVideoAd.setRewardedVideoAdListener(listener);
//        adsGoogleVideoLoad(unitId);
//    }
//
//    public void adsGoogleVideoLoad(String unitId) {
//        setLog("GoogleAdsZ | adsGoogleVideoLoad: onInitial");
//        mRewardedVideoAd.loadAd(unitId, new PublisherAdRequest.Builder().build());
//    }
//
//    public void adsGoogleVideoShow() {
//        setLog("GoogleAdsZ | adsGoogleVideoShow: onInitial");
//        if (mRewardedVideoAd.isLoaded()) {
//            setLog("GoogleAdsZ | adsGoogleVideoShow: isLoaded");
//            mRewardedVideoAd.show();
//        } else {
//            setLog("GoogleAdsZ | adsGoogleVideoShow: FAILED");
//        }
//    }

}
