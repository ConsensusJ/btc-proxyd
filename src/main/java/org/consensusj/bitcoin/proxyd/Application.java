package org.consensusj.bitcoin.proxyd;

import com.msgilligan.bitcoinj.rpc.BitcoinClient;
import io.micronaut.context.annotation.Factory;
import io.micronaut.runtime.Micronaut;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.consensusj.bitcoin.proxyd.service.JsonRpcProxyConfiguration;

import javax.inject.Singleton;

@Factory
public class Application {
    public static void main(String[] args) {
        Micronaut.build(args)
                .banner(false)
                .mainClass(Application.class)
                .start();
    }

    @Singleton
    public NetworkParameters networkParameters() {
        return MainNetParams.get();
    }

    @Singleton
    public Module jacksonModule(NetworkParameters networkParameters) {
        return new RpcServerModule(null);
    }

    @Singleton
    public Module jacksonModuleClient(NetworkParameters networkParameters) {
        return new RpcClientModule(null);
    }
}
