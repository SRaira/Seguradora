package seguradora;

import java.util.*;

//CRIANDO CLASSE
public class main {

    boolean flagPrincipal = false;

    //CRIANDO AS LISTAS
    private static List<Cliente> listaCliente = new ArrayList<Cliente>();
    private static List<Residencial> listaResidencial = new ArrayList<Residencial>();
    private static List<Empresarial> listaEmpresarial = new ArrayList<Empresarial>();

    //FEITO POR CONVENÇÃO
    public static void main(String[] args) {


        inicio();
    }

    public static void inicio() {


        boolean flag = false;
        while (!flag) {

            Cliente cliente = new Cliente();
            Residencial residencial = new Residencial();
            Empresarial empresarial = new Empresarial();
            String nome = null;
            String tipoPessoa = null;
            String endereco = null;
            double valorImovelR = 0;
            String tipoResdencia = null;
            String zona = null;
            double valorImovelE = 0;
            double numerosFuncionarios = 0;
            double visitasDiarias = 0;
            String ramo = null;
            double valorSeguro = 0;

            Scanner leitor = new Scanner(System.in);
            while (!flag) {
                System.out.println("Informe o nome do Cliente...: ");
                try {
                    nome = leitor.nextLine();
                    if ((nome == null) || (nome.trim().isEmpty())) {          //trim -> EXCLUI ESPAÇOS VAZIO AO LADO
                        throw new Exception("Nome invalido!");
                    }
                    if (nome.matches("[0-9teste!@#$%¨&*()+><,.|{}?´``]")) {      //EXCLUI OS CARACTERES SELECIONADOS
                        throw new Exception("Nome invalido");
                    }
                    nome = nome.toUpperCase();                                      //SE DIGITAR MINUSCULO - MUDA PARA MAIUSCULO
                    cliente.setNome(nome);
                    flag = true;
                } catch (Exception ex) {                                                    //erros gerais
                    System.out.println("Erro 002 - de input: Erro inesperado");
                }
            }

            flag = false;
            while (!flag) {
                System.out.println("Digite (F) para Pessoa Física (F) ou (J) para Pessoa Juridica: ");
                try {
                    tipoPessoa = leitor.nextLine();
                    if ((tipoPessoa == null) || (tipoPessoa.trim().isEmpty())) {
                        throw new Exception("erro.01 - VAZIO - TIPO INVALIDO! Digite (F) ou (J)");
                    }
                    if (!tipoPessoa.equals("F") && !tipoPessoa.equals("f") && !tipoPessoa.equals("J") && !tipoPessoa.equals("j")) {
                        throw new Exception("erro.02 - INPUT - TIPO INVALIDO! Digite (F) ou (J) ");
                    }
                    tipoPessoa = tipoPessoa.toUpperCase();
                    cliente.setTipoPessoa(tipoPessoa);
                    flag = true;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            listaCliente.add(cliente);

            //TODOS OS DADOS ARMAZENADOS VÃO PARA RESIDENCIAL

            if (tipoPessoa.equals("F")) {

                flag = false;
                while (!flag) {
                    System.out.println("Informe o endereço...: ");
                    try {
                        endereco = leitor.nextLine();
                        if ((endereco == null) || (endereco.trim().isEmpty())) {
                            throw new Exception("erro.01 - VAZIO - ENDEREÇO INVALIDO");
                        }
                        endereco = endereco.toUpperCase();
                        residencial.setEndereco(endereco);
                        flag = true;
                    } catch (Exception ex) {
                        System.out.println("erro.03 - ENDEREÇO INVALIDO");
                    }
                }

                flag = false;                       //TESTAR O VALOR ESTA GERANDO LOOP QUANDO DIGITA LETRAS
                while (!flag) {
                    System.out.println("Informe o Valor do imovél: ");
                    try {
                        valorImovelR = leitor.nextInt();
                        if (valorImovelR <= 0) {
                            throw new Exception("erro.02 - INPUT - VALOR INVALIDO");
                        } else {
                            flag = true;
                        }
                        residencial.setValorImovel(valorImovelR);
                        flag = true;
                    } catch(InputMismatchException ex){
                        System.out.println(ex.getMessage());
                        valorImovelR = leitor.nextInt();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    valorSeguro = residencial.calcularSeguro();
                }

                flag = false;
                while (!flag) {
                    System.out.println("Informe a zona na qual o imóvel se encontra: (U) para URBANO, (S) para SUBURBANA ou (R) RURAL ");
                    try {
                        zona = leitor.next();
                        if ((zona == null) || (zona.trim().isEmpty())) {
                            throw new Exception("erro.01 - VAZIO - ZONA INVALIDA! Digite apenas (U), (S) ou (R)");
                        }
                        if (!zona.equals("U") && !zona.equals("u") && !zona.equals("S") && !zona.equals("s") && !zona.equals("R") && !zona.equals("r")) {
                            throw new Exception("erro.02 - INPUT - ZONA INVALIDA! Digite apenas (U), (S) ou (R)");
                        }
                        zona = zona.toUpperCase();
                        residencial.setZona(zona);
                        flag = true;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    if (zona.equals("U")) {
                        valorSeguro = valorSeguro + (residencial.valorSeguroUrbano());
                    } else {
                        if (zona.equals("S")) {
                            valorSeguro = valorSeguro + (residencial.valorSeguroSuburbano());
                        }
                    }
                }

                flag = false;
                while (!flag) {
                    System.out.println("Informe o tipo de residencia (A) para APARTAMENTO ou (C) para CASA: ");
                    try {
                        tipoResdencia = leitor.next();
                        if ((tipoResdencia == null) || (tipoResdencia.trim().isEmpty())) {
                            throw new Exception("erro.01 - VAZIO - TIPO DE RESIDENCIA INVALIDO!");
                        }
                        if (!tipoResdencia.equals("A") && !tipoResdencia.equals("a") && !tipoResdencia.equals("C") && !tipoResdencia.equals("c")) {
                            throw new Exception("erro.02 - INPUT - RTIPO DE RESIDENCIA INVALIDO! Digite apenas (A) OU (C) ");
                        }
                        tipoResdencia = tipoResdencia.toUpperCase();
                        residencial.setTipoResidencia(tipoResdencia);
                        flag = true;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    if (tipoResdencia.equals("C")) {
                        valorSeguro = valorSeguro + (residencial.valorTipoResidencia());
                    }
                }

                System.out.println("O Valor do seguro é :" + valorSeguro);


            }


            // TODOS OS DADOS ARMAZENADOS VÃO PARA EMPRESARIAL

            listaResidencial.add(residencial);


            if (tipoPessoa.equals("J")) {


                flag = false;                       //TESTAR O VALOR ESTA GERANDO LOOP QUANDO DIGITA LETRAS
                while (!flag) {
                    System.out.println("Informe o valor do imovél: ");
                    try {
                        valorImovelE = leitor.nextFloat();
                        if (valorImovelE <= 0) {
                            throw new Exception("erro.02 - INPUT - VALOR INVALIDO");
                        }
                        empresarial.setValorImovelE(valorImovelE);
                        flag = true;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    valorSeguro = empresarial.calcularSeguro();
                }


                flag = false;
                while (!flag) {
                    System.out.println("Informe o número de funcionários:");
                    try {
                        numerosFuncionarios = leitor.nextFloat();
                        if ((numerosFuncionarios <= 0)) {
                            throw new Exception("erro.02 - INPUT - VALOR INVALIDO");
                        }
                        empresarial.setNumerosFuncionarios(numerosFuncionarios);
                        flag = true;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    for (int i = 10; i <= numerosFuncionarios; i += 10) {
                        valorSeguro = valorSeguro + (valorSeguro * 0.002);

                    }
                }

                flag = false;
                while (!flag) {
                    System.out.println("Informe o Número de visitas diárias: ");
                    try {
                        visitasDiarias = leitor.nextInt();
                        if ((visitasDiarias <= 0)) {
                            throw new Exception("erro.02 - INPUT - VALOR INVALIDO");
                        }
                        empresarial.setVisitasDiarias(visitasDiarias);
                        flag = true;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    for (int i = 200; i <= visitasDiarias; i += 200) {
                        valorSeguro = valorSeguro + (valorSeguro * 0.003);
                    }

                    flag = false;
                    while (!flag) {
                        System.out.println("Informe o Ramo: (C) para Comércio, (I) para Indústria ou (A) para agropecuária: ");
                        try {
                            ramo = leitor.next();
                            if ((ramo == null) || (ramo.trim().isEmpty())) {
                                throw new Exception("erro.01 - VAZIO - VALOR INVALIDO");
                            }
                            if (!ramo.equals("C") && !ramo.equals("c") && !ramo.equals("I") && !ramo.equals("i") && !ramo.equals("A") && !ramo.equals("a")) {
                                throw new Exception("erro.02 - INPUT - RAMO INVALIDO! Digite apenas (C), (I) ou (A)");
                            }
                            empresarial.setRamo(ramo);
                            ramo = ramo.toUpperCase();
                            flag = true;
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }

                        if (ramo.equals("C")) {
                            valorSeguro = valorSeguro + (empresarial.valorRamoComercio());
                        } else {
                            if (ramo.equals("I")) {
                                valorSeguro = valorSeguro + (empresarial.valorRamoIndustria());
                            }
                        }
                        System.out.println("O Valor do seguro é: " + valorSeguro);
                    }
                }
                listaEmpresarial.add(empresarial);
            }


            String sair = null;
            leitor = new Scanner(System.in);
            System.out.println("DESEJA SAIR?");
            sair = leitor.nextLine();
            if (sair.equals("SIM") && sair.equals("sim") && sair.equals("s") && sair.equals("S")) {
                for (int i = 0; i < listaCliente.size(); i++) {
                    if (listaCliente.get(i).getTipoPessoa().equals("F")) {
                        System.out.println(listaCliente.get(i).getNome() + " Pessoa Física");
                    } else {
                        System.out.println("Pessoa Jurídica");
                    }
                }
                for (int i = 0; i < listaResidencial.size(); i++) {
                    System.out.println(listaResidencial.get(i).getEndereco());
                    System.out.println(listaResidencial.get(i).getValorImovelR() + "Valor");
                    if (listaResidencial.get(i).getZona().equals("U")) {
                        System.out.println(listaResidencial.get(i).getZona() + "Zona Urbana");
                    }
                    if (listaResidencial.get(i).getZona().equals("S")) {
                        System.out.println(listaResidencial.get(i).getZona() + "Zona Suburbana");
                    } else {
                        System.out.println("Zona Rural");
                    }
                    if (listaResidencial.get(i).getTipoResidencia().equals("C")) {
                        System.out.println(listaResidencial.get(i).getZona() + "Casa");
                    } else {
                        System.out.println("Apartamento");
                    }
                }

                for (int i = 0; i < listaEmpresarial.size(); i++) {
                    System.out.println(listaEmpresarial.get(i).getValorImovelE());
                    System.out.println(listaEmpresarial.get(i).getNumerosFuncionarios());
                    System.out.println(listaEmpresarial.get(i).getVisitasDiarias());
                    if (listaEmpresarial.get(i).getRamo().equals("I")) {
                        System.out.println(listaEmpresarial.get(i).getRamo() + "Induustria");
                    } else {
                        System.out.println("Comercio");
                    }
                }
                flag = true;
            } else {
                flag = false;
                }
            }
        }
    }













