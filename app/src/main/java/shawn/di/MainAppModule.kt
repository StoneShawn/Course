package shawn.di

import com.shawn.data.di.dataKoinModule
import com.shawn.di.syncWorkerKoinModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import shawn.ui.course.list.CourseListViewModel

val mainAppModule = module {
    includes(dataKoinModule, syncWorkerKoinModule)

    viewModelOf(::CourseListViewModel)
}