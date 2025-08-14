package app.open_football_competitions.di

import app.open_football_competitions.data.remote.FootballApi
import app.open_football_competitions.data.repo_impl.FootballRepositoryImpl
import app.open_football_competitions.domain.repo.FootballRepository
import app.open_football_competitions.domain.usecase.GetCompetitionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.football-data.org/v4/"

    @Provides
    @Singleton
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): FootballApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: FootballApi): FootballRepository =
        FootballRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetCompetitionsUseCase(repo: FootballRepository) =
        GetCompetitionsUseCase(repo)

}