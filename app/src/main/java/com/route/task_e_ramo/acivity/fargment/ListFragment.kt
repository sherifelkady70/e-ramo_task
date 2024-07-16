package com.route.task_e_ramo.acivity.fargment


//class ListFragment : Fragment() {

//    private lateinit var binding: FragmentListBinding
//    val projectItemsAdapter = BrokerAdapter()
//    private val viewModel : DetailsFragmentViewModel by viewModels<DetailsFragmentViewModel>()
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//        binding = FragmentListBinding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initViews()
//    }
//    private fun initViews(){
//        binding.brokersRv.adapter=projectItemsAdapter
//        lifecycleScope.launch {
//            viewModel.projectItemList.collect{
//                projectItemsAdapter.bindList(it)
//            }
//        }
//    }
//}