package com.ilunin.consul

import com.ning.http.client._

class HttpClient(val asyncHttpClient: AsyncHttpClient) {

  def this() = this(new AsyncHttpClient())

  def this(provider: AsyncHttpProvider) = this(new AsyncHttpClient(provider))

  def this(config: AsyncHttpClientConfig) = this(new AsyncHttpClient(config))

  def this(httpProvider: AsyncHttpProvider, config: AsyncHttpClientConfig) = this(new AsyncHttpClient(httpProvider, config))

  def this(providerClass: String, config: AsyncHttpClientConfig) = this(new AsyncHttpClient(providerClass, config))

  def close(): Unit = asyncHttpClient.close()

  def closeAsynchronously(): Unit = asyncHttpClient.closeAsynchronously()

  def getConfig: AsyncHttpClientConfig = asyncHttpClient.getConfig

  def getProvider: AsyncHttpProvider = asyncHttpClient.getProvider

  def isClosed: Boolean = asyncHttpClient.isClosed

  def prepareConnect(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.prepareConnect(url)

  def prepareDelete(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.prepareDelete(url)

  def prepareGet(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.prepareGet(url)

  def prepareHead(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.prepareHead(url)

  def prepareOptions(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.prepareOptions(url)

  def preparePatch(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.preparePatch(url)

  def preparePost(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.preparePost(url)

  def preparePut(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.preparePut(url)

  def prepareTrace(url: String): AsyncHttpClient#BoundRequestBuilder = asyncHttpClient.prepareTrace(url)

  def setSignatureCalculator(signatureCalculator: SignatureCalculator): AsyncHttpClient = asyncHttpClient.setSignatureCalculator(signatureCalculator)

}
