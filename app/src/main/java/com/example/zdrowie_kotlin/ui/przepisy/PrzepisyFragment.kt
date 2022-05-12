package com.example.zdrowie_kotlin.ui.przepisy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.zdrowie_kotlin.R
import com.example.zdrowie_kotlin.databinding.FragmentPrzepisyBinding
import java.util.*

class PrzepisyFragment : Fragment() {
    private var binding: FragmentPrzepisyBinding? = null
    private var adapter1: ArrayAdapter<String>? = null
    private var adapter2: ArrayAdapter<String>? = null
    private var adapter3: ArrayAdapter<String>? = null
    private var adapter4: ArrayAdapter<String>? = null
    var skladniki1 = arrayOf(
        "2 średnie marchewki (ok. 300 g)",
        "1 małe jabłko",
        "1 słoiczek tartego selera z ananasem lub bez",
        "1 łyżka posiekanej natki",
        "1,5 łyżki oliwy lub oleju roślinnego",
        "sok z 1/2 cytryny",
        "1 łyżeczka miodu",
        "mała szczypta soli i świeżo zmielony pieprz"
    )
    var przygotowanie1 = arrayOf(
        "Marchewkę oraz jabłko obrać i zetrzeć na małych oczkach tarki, włożyć do salaterki.",
        "Dodać odcedzonego selera (delikatnie odciśniętego) oraz natkę pietruszki.",
        "Wymieszać składniki sosu i połączyć ze składnikami surówki."
    )
    var skladniki2 = arrayOf(
        "1/4 szklanki kaszy jaglanej",
        "1 szklanka mleka roślinnego",
        "owoce np. mango, papaja, granat, banan, marakuja",
        "1 łyżka soku z limonki",
        "kilka orzechów pekan",
        "syrop klonowy"
    )
    var przygotowanie2 = arrayOf(
        "Kaszę jaglaną wsypać do garnka, dokładnie wypłukać zmieniając ciepłą wodę. Wylać wodę, wlać mleko, wymieszać i zagotować (uwaga, będzie kipieć).",
        "Ustawić garnek na najmniejszym palniku, zmniejszyć ogień do minimum i gotować pod przykryciem przez ok. 15 minut.",
        "Przygotować owoce: obrać i pokroić w kostkę. Granata pokroić i wyłuskać nasiona. Marakuję przepołowić i łyżeczką wyjąć zawartość.",
        "Ugotowaną kaszę jaglaną wyłożyć do miseczki, dodać owoce, skropić sokiem z limonki, posypać orzechami i polać syropem klonowym."
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrzepisyBinding.inflate(inflater, container, false)
        val root: View = binding!!.getRoot()
        val skladnikiListView1 = binding!!.skladnikiListView1 as ListView
        val przygotowanieListView1 = binding!!.przygotowanieListView1 as ListView
        val skladnikiList1 = ArrayList<String>()
        skladnikiList1.addAll(Arrays.asList(*skladniki1))
        val przygotowanieList1 = ArrayList<String>()
        przygotowanieList1.addAll(Arrays.asList(*przygotowanie1))
        adapter1 = ArrayAdapter(requireActivity(), R.layout.przepisy_item, skladnikiList1)
        adapter2 = ArrayAdapter(requireActivity(), R.layout.przygotowanie_item, przygotowanieList1)
        skladnikiListView1.adapter = adapter1
        przygotowanieListView1.adapter = adapter2

        // -----------
        val skladnikiListView2 = binding!!.skladnikiListView2 as ListView
        val przygotowanieListView2 = binding!!.przygotowanieListView2 as ListView
        val skladnikiList2 = ArrayList<String>()
        skladnikiList2.addAll(Arrays.asList(*skladniki2))
        val przygotowanieList2 = ArrayList<String>()
        przygotowanieList2.addAll(Arrays.asList(*przygotowanie2))
        adapter3 = ArrayAdapter(requireActivity(), R.layout.przepisy_item, skladnikiList2)
        adapter4 = ArrayAdapter(requireActivity(), R.layout.przygotowanie_item, przygotowanieList2)
        skladnikiListView2.adapter = adapter3
        przygotowanieListView2.adapter = adapter4
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}