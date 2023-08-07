package club.supreme.message.provider;

import club.supreme.message.enums.ProviderType;
// import club.supreme.message.model.ProviderConfig;

import java.util.Map;

public class ProviderFactory {
    private Map<ProviderType, Provider> providers;
    public void registerProvider(ProviderType providerType, Provider provider) {
        providers.put(providerType, provider);
    }
    // public Provider getProvider(ProviderConfig providerConfig) {
    //     return providers.get(providerConfig.getProviderType());
    // }
}