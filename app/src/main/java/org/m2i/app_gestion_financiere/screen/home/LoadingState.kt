package org.m2i.app_gestion_financiere.screen.home

import javax.net.ssl.SSLEngineResult.Status

data class LoadingState(val  status:Status, val message : String? = null) {
    companion object{
    }
}
